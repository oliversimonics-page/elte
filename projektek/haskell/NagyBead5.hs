module NagyBead where

import Data.Either
import Data.Maybe
import Text.Read

basicInstances = 0 -- Mágikus tesztelőnek kell ez, NE TÖRÖLD!

data Dir = InfixL | InfixR deriving (Show, Eq, Ord)
data Tok a = BrckOpen | BrckClose | TokLit a | TokBinOp (a -> a -> a) Char Int Dir | TokFun (a->a) String
data ShuntingYardError = OperatorOrClosingParenExpected | LiteralOrOpeningParenExpected | NoClosingParen | NoOpeningParen | ParseError deriving (Show, Eq)

instance Show a => Show (Tok a) where
   show BrckOpen = "BrckOpen"
   show BrckClose = "BrckClose"
   show (TokLit a) = "TokLit " ++ show a 
   show (TokBinOp _ c i d) = "TokBinOp" ++ ' ' : show c ++ ' ' : show i ++ ' ' : show d
   show (TokFun _ y) = "TokFun " ++ y

instance Eq a => Eq (Tok a) where
   BrckOpen == BrckOpen = True
   BrckClose == BrckClose = True
   (TokLit x) == (TokLit y) = x == y
   (TokBinOp _ c i d) == (TokBinOp _ ca ia da) = c == ca && i == ia && d == da
   (TokFun _ y) == (TokFun _ x) = x == y
   _ == _ = False

type ShuntingYardResult a = Either ShuntingYardError a
type OperatorTable a = [(Char, (a -> a -> a, Int, Dir))]
type FunctionTable a = [(String, (a->a))]

tAdd, tMinus, tMul, tDiv, tPow :: (Floating a) => Tok a
tAdd = TokBinOp (+) '+' 6 InfixL
tMinus = TokBinOp (-) '-' 6 InfixL
tMul = TokBinOp (*) '*' 7 InfixL
tDiv = TokBinOp (/) '/' 7 InfixL
tPow = TokBinOp (**) '^' 8 InfixR

operatorTable :: (Floating a) => OperatorTable a
operatorTable =
    [ ('+', ((+), 6, InfixL))
    , ('-', ((-), 6, InfixL))
    , ('*', ((*), 7, InfixL))
    , ('/', ((/), 7, InfixL))
    , ('^', ((**), 8, InfixR))
    ]

tSin, tCos, tLog, tExp, tSqrt :: Floating a => Tok a
tSin = TokFun sin "sin"
tCos = TokFun cos "cos"
tLog = TokFun log "log"
tExp = TokFun exp "exp"
tSqrt = TokFun sqrt "sqrt"

functionTable :: (RealFrac a, Floating a) => FunctionTable a
functionTable =
    [ ("sin", sin)
    , ("cos", cos)
    , ("log", log)
    , ("exp", exp)
    , ("sqrt", sqrt)
    , ("round", (\x -> fromIntegral (round x :: Integer)))
    ]

-- 1. feladat
operatorFromChar :: OperatorTable a -> Char -> Maybe (Tok a)
operatorFromChar [] x = Nothing
operatorFromChar ((a,(op,num,f)):xs) x
   | x == a = Just (TokBinOp op a num f)
   | otherwise = operatorFromChar xs x

-- 2. feladat
parseTokens :: Read a => OperatorTable a -> String -> Maybe [Tok a]
parseTokens tabla szavak
   | uresE (segitTokens tabla (words szavak)) = Nothing
   | otherwise = Just (map (fromJust) (segitTokens tabla (words szavak)))

segitTokens :: (Read a) => OperatorTable a -> [String] -> [Maybe (Tok a)]
segitTokens tabla [] = []
segitTokens tabla (s@(x:y:xs):ys)
   | mind s = segitTokens tabla ((zarojel s) ++ ys)
segitTokens tabla (s@(x:xs):ys)
   | s == "(" = Just BrckOpen : segitTokens tabla ys
   | s == ")" = Just BrckClose : segitTokens tabla ys
   | [] == xs && isJust (operatorFromChar tabla x) = operatorFromChar tabla x : segitTokens tabla ys
   | isJust rd = Just (TokLit (fromJust(rd))) : segitTokens tabla ys
   | otherwise = [Nothing]
  where
    rd = readMaybe s

uresE :: [Maybe a] -> Bool
uresE [] = False
uresE (Nothing:xs) = True
uresE (x:xs) = uresE xs

mind :: String -> Bool
mind [] = True
mind (x:xs)
   | x == '(' || x == ')' = mind xs
   | otherwise = False

zarojel :: String -> [String]
zarojel [] = []
zarojel (x:xs) = [x] : zarojel xs
-- 3. feladat
shuntingYardBasic :: [Tok a] -> ([a], [Tok a])
shuntingYardBasic lista = szetszed lista [] []

szetszed :: [Tok a] -> [a] -> [Tok a] -> ([a], [Tok a])
szetszed [] lit op = (lit, op)
szetszed (x:xs) lit op
   | isToklit x = szetszed xs (ertek(x):lit) op
   | isop x || isbrcko x = szetszed xs lit (x:op)
   | otherwise = szetszed xs (kiertekel elotte lit) utana
   where
    elotte = takeWhile (not . isbrcko) op
    utana = tail (dropWhile (not . isbrcko) op)

-- 4. feladat
shuntingYardPrecedence :: [Tok a] -> ([a], [Tok a])
shuntingYardPrecedence lista = szetszed1 lista [] []

szetszed1 :: [Tok a] -> [a] -> [Tok a] -> ([a], [Tok a])
szetszed1 [] lit op = (lit, op)
szetszed1 ((TokLit x):xs) lit op = szetszed1 xs (x:lit) op
szetszed1 (x@(BrckOpen):xs) lit op = szetszed1 xs lit (x:op)
szetszed1 ((BrckClose):xs) lit op = szetszed1 xs (kiertekel elotte lit) utana
   where
    elotte = takeWhile (not . isbrcko) op
    utana = tail (dropWhile (not . isbrcko) op)
szetszed1 (o:xs) lit op
   | kiKell o op = szetszed1 (o:xs) (kiertekel [(head op)] lit) (tail op)
   | otherwise = szetszed1 xs lit (o:op)

eqError = 0 -- Mágikus tesztelőnek szüksége van rá, NE TÖRÖLD!
-- 1. plusz feladat
-- +1/a parsolás
parseSafe :: Read a => OperatorTable a -> String -> ShuntingYardResult [Tok a]
parseSafe tabla szavak
   | uresE (segitTokens tabla (words szavak)) = Left ParseError
   | otherwise = Right (map (fromJust) (segitTokens tabla (words szavak)))

-- +1/b Kiértékelés hibakereséssel
shuntingYardSafe :: [Tok a] -> ShuntingYardResult ([a], [Tok a])
shuntingYardSafe lista = szetszedComplete lista [] []
-- +2. feladatot
-- +2/a parsolás
funfromChar :: FunctionTable a -> String -> Maybe (Tok a)
funfromChar [] x = Nothing
funfromChar ((a,b):xs) x
   | x == a = Just (TokFun b a)
   | otherwise = funfromChar xs x

parseWithFunctions :: Read a => OperatorTable a -> FunctionTable a -> String -> Maybe [Tok a] 
parseWithFunctions tabla tabla1 szavak
   | uresE (segitTokensFun tabla tabla1 (words szavak)) = Nothing
   | otherwise = Just (map (fromJust) (segitTokensFun tabla tabla1 (words szavak)))

segitTokensFun :: (Read a) => OperatorTable a -> FunctionTable a -> [String] -> [Maybe (Tok a)]
segitTokensFun tabla tabla1 [] = []
segitTokensFun tabla tabla1 (s@(x:y:xs):ys)
   | mind s = segitTokensFun tabla tabla1 ((zarojel s) ++ ys)
segitTokensFun tabla tabla1 (s@(x:xs):ys)
   | s == "(" = Just BrckOpen : segitTokensFun tabla tabla1 ys
   | s == ")" = Just BrckClose : segitTokensFun tabla tabla1 ys
   | [] == xs && isJust (operatorFromChar tabla x) = operatorFromChar tabla x : segitTokensFun tabla tabla1 ys
   | isJust (funfromChar tabla1 s) = funfromChar tabla1 s : segitTokensFun tabla tabla1 ys
   | isJust rd =  Just (TokLit (fromJust(rd))) : segitTokensFun tabla tabla1 ys
   | otherwise = [Nothing]
  where
   rd = readMaybe s

-- +2/b shunting
shuntingYardWithFunctions :: [Tok a] -> ([a], [Tok a])
shuntingYardWithFunctions lista = szetszed1 lista [] []

-- +2/c parsolás
parseComplete :: Read a => OperatorTable a -> FunctionTable a -> String -> ShuntingYardResult [Tok a]
parseComplete tabla tabla1 szavak
   | uresE (segitTokensFun tabla tabla1 (words szavak)) = Left ParseError
   | otherwise = Right (map (fromJust) (segitTokensFun tabla tabla1 (words szavak)))
--
-- +2/c shunting
shuntingYardComplete :: [Tok a] -> ShuntingYardResult ([a], [Tok a])
shuntingYardComplete lista = szetszedComplete lista [] []

szetszedComplete :: [Tok a] -> [a] -> [Tok a] -> ShuntingYardResult ([a], [Tok a])
szetszedComplete [] lit op 
   | elemeO op = Left NoClosingParen
   | otherwise = Right (lit, op)
-- operátornál
szetszedComplete [(TokBinOp _ _ _ _)] lit op = Left LiteralOrOpeningParenExpected
szetszedComplete ((TokBinOp _ _ _ _):x:xs) lit op
   | length lit == 0 = Left LiteralOrOpeningParenExpected
   | isop x || isbrclose x = Left LiteralOrOpeningParenExpected
-- (
szetszedComplete ((BrckOpen):x:xs) lit op
   | isbrclose x = Left LiteralOrOpeningParenExpected
   | isop x = Left LiteralOrOpeningParenExpected
-- )
szetszedComplete [(BrckClose)] [] [] = Left OperatorOrClosingParenExpected
szetszedComplete ((BrckClose):x:xs) lit op
   | length lit == 0 = Left OperatorOrClosingParenExpected
   | isbrcko x || isToklit x || isfgv x = Left OperatorOrClosingParenExpected
   | not (elemeO op) = Left NoOpeningParen
-- Lit
szetszedComplete ((TokLit _):x:xs) lit op
   | isToklit x || isbrcko x || isfgv x = Left OperatorOrClosingParenExpected
-- fgv
szetszedComplete [(TokFun _ _)] lit op = Left LiteralOrOpeningParenExpected
szetszedComplete ((TokFun _ _):x:xs) lit op
   | isbrclose x || isop x = Left LiteralOrOpeningParenExpected
-- ugyanaz mint a simánál kb
szetszedComplete ((TokLit x):xs) lit op = szetszedComplete xs (x:lit) op
szetszedComplete (x@(BrckOpen):xs) lit op = szetszedComplete xs lit (x:op)
szetszedComplete ((BrckClose):xs) lit op 
   | ures(dropWhile (not . isbrcko) op) = Left NoOpeningParen -- ha nincs BrckOpen a BrckClose hoz
   | otherwise = szetszedComplete xs (kiertekel elotte lit) utana
   where 
    elotte = takeWhile (not . isbrcko) op
    utana = tail (dropWhile (not . isbrcko) op)
szetszedComplete (o:xs) lit op
   | kiKell o op = szetszedComplete (o:xs) (kiertekel [(head op)] lit) (tail op)
   | otherwise = szetszedComplete xs lit (o:op)

--segégfüggvények
isToklit :: Tok a -> Bool
isToklit (TokLit x) = True
isToklit _ = False

isop :: Tok a -> Bool
isop (TokBinOp _ _ _ _) = True
isop _ = False

isbrcko :: Tok a -> Bool
isbrcko BrckOpen = True
isbrcko _ = False

isbrclose :: Tok a -> Bool
isbrclose BrckClose = True
isbrclose _ = False

isfgv :: (Tok a) -> Bool
isfgv (TokFun _ _) = True
isfgv _ = False

ertek :: Tok a -> a
ertek (TokLit x) = x

kiKell :: Tok a -> [Tok a] -> Bool
kiKell _ [] = False
kiKell (TokBinOp _ _ x InfixL) ((TokBinOp _ _ y _):xs) = x <= y
kiKell (TokBinOp _ _ x InfixR) ((TokBinOp _ _ y _):xs) = x < y
kiKell (TokFun _ _) _ = False
kiKell _ ((TokFun _ _):xs) = True
kiKell _ (BrckOpen:xs) = False

kiertekel :: [Tok a] -> [a] -> [a]
kiertekel [] xs = xs
kiertekel ((TokBinOp jegy _ _ _):xs) (y1:y2:ys)= kiertekel xs ((jegy y2 y1):ys)
kiertekel ((TokFun x _):xs) (y:ys) = kiertekel xs ((x y):ys) --késöbbi

elemeO :: [(Tok a)] -> Bool
elemeO [] = False
elemeO (BrckOpen:xs) = True
elemeO (_:xs) = elemeO xs

ures :: [Tok a] -> Bool
ures [] = True
ures _ = False

-- tesztekhez
getOp :: (Floating a) => Char -> Maybe (Tok a)
getOp = operatorFromChar operatorTable
parse :: String -> Maybe [Tok Double]
parse = parseTokens operatorTable
parseAndEval :: (String -> Maybe [Tok a]) -> ([Tok a] -> ([a], [Tok a])) -> String -> Maybe ([a], [Tok a])
parseAndEval parse eval input = maybe Nothing (Just . eval) (parse input)
syNoEval :: String -> Maybe ([Double], [Tok Double])
syNoEval = parseAndEval parse shuntingYardBasic
syEvalBasic :: String -> Maybe ([Double], [Tok Double])
syEvalBasic = parseAndEval parse (\t -> shuntingYardBasic $ BrckOpen : (t ++ [BrckClose]))
syEvalPrecedence :: String -> Maybe ([Double], [Tok Double])
syEvalPrecedence = parseAndEval parse (\t -> shuntingYardPrecedence $ BrckOpen : (t ++ [BrckClose]))
parseAndEvalSafe :: (String -> ShuntingYardResult [Tok a]) -> ([Tok a] -> ShuntingYardResult ([a], [Tok a])) -> String -> ShuntingYardResult ([a], [Tok a])
parseAndEvalSafe parse eval input = either Left eval (parse input)
sySafe :: String -> ShuntingYardResult ([Double], [Tok Double])
sySafe = parseAndEvalSafe (parseSafe operatorTable) (\ts -> shuntingYardSafe (BrckOpen : ts ++ [BrckClose]))
syFun :: String -> Maybe ([Double], [Tok Double])
syFun = parseAndEval (parseWithFunctions operatorTable functionTable) (\t -> shuntingYardWithFunctions $ BrckOpen : (t ++ [BrckClose]))
syComplete :: String -> ShuntingYardResult ([Double], [Tok Double])
syComplete = parseAndEvalSafe (parseComplete operatorTable functionTable) (\ts -> shuntingYardComplete (BrckOpen : ts ++ [BrckClose]))