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
"--------Problem 2-----------"
(define truecount '(#t #t #f #t))
(count identity truecount)

;problem 3
"--------Problem 3-----------"
(define (squarelist alist) (map (lambda (x) (* x x)) alist))
(squarelist (list 1 2 3 4 ))
;problem 4
"--------Problem 4-----------"
(define (hundred? slist)(filter  (lambda(x) (and (number? x) (> x 100))) slist))
(hundred? (list 101 20 300 400))
;problem 5
;(define (collatz n ) (cond ((even? n) (/ n 2)) (odd? n ( + ( * 3 n ) 1)) (else( collatz - n 1))))
"--------Problem 5-----------"
	
(define (collatz n)   
    (define (loop n counter)
      (display n )(newline)
      (if (<=  n 1) counter
      (if (even? n)  (loop (/ n 2) (+ counter 1))
                     (loop (+ (* n 3) 1) (+ counter 1)))))
  (loop n 0)
)
(collatz 5)
