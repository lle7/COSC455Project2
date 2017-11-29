#lang racket
"--------Example-----------"
(define mylist(list 1 2 3 4))
(car mylist);get the head of the list 
(cdr mylist);get the tail of the list
(car (cdr mylist));get the head of the tail of the last list
(cadr mylist);same thing as the previous, get the head of the tail but shorter verison
(car (cdr (cdr (cdr mylist))));get the last element in the list 
(cadddr mylist); get the last element 

(define alist'())
(define anotherlist'(a b c))
(set! alist(cons (car anotherlist) alist))
(set! alist(cons (car (cdr anotherlist)) alist))
(display(reverse alist))

(define capitals '((maryland(annapolis)) (pennsylvania(harrisburg)) (delaware(dover)) (virginia(richmond))))
(car (cdr capitals))
(cadr capitals)
(cadar capitals)
(caadar capitals)

;problem 1
;get the head of the list 
"--------Problem 1-----------"
(define first (lambda (x) (car x)))
(define second (lambda (x) (cadr x)))
(define third (lambda (x) (caddr x)))
(define fourth (lambda (x) (cadddr x)))
(define fifth (lambda (x) (car(cddddr x))))
(define rest (lambda (x) (cdr x)))
(define family '(josh sara erin sandy jon))
(first family)
(second family)
(third family)
(fourth family)
(fifth family)
;problem 2
;Develop a function, named truecount, that takes a list of booleans (i.e., #t or #f) and returns the number of trues (i.e., #t) in the list and include it in your submission.
"--------Problem 2-----------"
(define truecount '(#t #t #f #t))
(count identity truecount)

;problem 3
;With this, develop a function, named squarelist, that takes a list and squares each item ofthe list and include it in your submission.
"--------Problem 3-----------"
(define (squarelist alist) (map (lambda (x) (* x x)) alist))
(squarelist (list 1 2 3 4 ))
;problem 4
;With this, develop a function, named hundreds?, that takes a list and returns any integer greater than 100. To do so, use Scheme’s filter function and an anonymous function in
;your hundreds? function. 
"--------Problem 4-----------"
(define (hundred? slist)(filter  (lambda(x) (and (number? x) (> x 100))) slist))
(hundred? (list 101 20 300 400))
;problem 5
;Develop a function, named collatz, that takes an integer, n, and prints out thehailstone sequence. The hailstone sequence is determined as follows: if n is even, the
;function divides it by 2 to get n / 2, if n is odd multiply it by 3 and add 1 to obtain 3n + 1. Repeat the process until you reach 1. 
;(define (collatz n ) (cond ((even? n) (/ n 2)) (odd? n ( + ( * 3 n ) 1))))
"--------Problem 5-----------"
	
(define (collatz n)   
      (display n )(newline)
      (cond ((eq? n 1)(display "End"))((even? n)(collatz(/ n 2)))((odd? n) (collatz(+ (* n 3) 1)))))
(collatz 5)
