(count [19 "yellow" true]) ; -> 3
(conj [1 2 3] 4)  ;  i THINK this will make [1 2 3 4]
(reverse [2 4 7]) ; -> (7 4 2)

; The next line uses an anonymous function that adds 3 to its argument.
(map #(+ % 3) [2 4 7]) ; -> (5 7 10)
(map + [2 4 7] [5 6] [1 2 3 4]) ; adds corresponding items -> (8 12)

(apply + [2 4 7]); -> 13 (useful if you already have a collection and want to use it as an argument list to a function)

(def stooges ["Moe" "Larry" "Curly" "Shemp"])
(first stooges) ; -> "Moe"
(second stooges) ; -> "Larry"
(last stooges) ; -> "Shemp"
(nth stooges 2) ; indexes start at 0 -> "Curly"
(next stooges) ; -> ("Larry" "Curly" "Shemp")
(butlast stooges) ; -> ("Moe" "Larry" "Curly")
(drop-last 2 stooges) ; -> ("Moe" "Larry")
; Get names containing more than three characters.
(filter #(> (count %) 3) stooges) ; -> ("Larry" "Curly" "Shemp")
(nthnext stooges 2) ; -> ("Curly" "Shemp")
(every? #(instance? String %) stooges) ; -> true
(not-every? #(instance? String %) stooges) ; -> false
(some #(instance? Number %) stooges) ; -> nil
(not-any? #(instance? Number %) stooges) ; -> true

; lists
(comment "They are ideal when new items will be added to or removed from the front (constant-time)." 
	     "They are not efficient (linear time) for finding items by index (using nth ). " 
	     "There is no efficient way to change items by index.")
;; THESE ARE ALL EQUIVALENT WAYS TO BUID A LIST
(def stooges (list "Moe" "Larry" "Curly"))
(def stooges (quote ("Moe" "Larry" "Curly")))
(def stooges '("Moe" "Larry" "Curly"))

(some #(= % "Moe") stooges) ; -> true 
(some #(= % "Mark") stooges) ; -> nil 
; Another approach is to create a set from the list
; and then use the contains? function on the set as follows.
(contains? (set stooges) "Moe") ; -> true
; SETS are much more efficient at finding a single item in a collection than lists

(def more-stooges (conj stooges "Shemp")) -> ("Shemp" "Moe" "Larry" "Curly")
(def less-stooges (remove #(= % "Curly") more-stooges)) ; -> ("Shemp" "Moe" "Larry")

;; COMBINE LISTS:
(def kids-of-mike '("Greg" "Peter" "Bobby"))
(def kids-of-carol '("Marcia" "Jan" "Cindy"))
(def brady-bunch (into kids-of-mike kids-of-carol))
(println brady-bunch) ; -> (Cindy Jan Marcia Greg Peter Bobby)

(peek brady-bunch)  ;  -> Cindy
(pop brady-bunch)  ; -> Cindy (collection is now one less)