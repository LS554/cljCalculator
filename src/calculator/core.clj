;; Copyright (c) 2025 London Sheard
;;
;; This software is released under the BSD 3-Clause License.
;; See LICENSE file for details.

(ns calculator.core
  (:gen-class))

(defn input_module [prompt] "Results user input"
  (print prompt)
  (flush)
  (read-line))

(defn parse_module [num]
  (try
    (Float/parseFloat num)
    (catch Exception _ nil)))

(defn calculate_module [num1 num2 operator] "Returns calculation "
  (case operator
    "+" (+ num1 num2)
    "-" (- num1 num2)
    "*" (* num1 num2)
    "/" (if (zero? num2)
          "Error, Division by zero."
          (/ num1 num2))
    "Error, Invalid operation."))

(defn display_module [] "Main display"
  (let [num1 (parse_module (input_module "Enter first number: "))
        num2 (parse_module (input_module "Enter second number: "))
        operator (input_module "Enter operation (+ - * /): ")
        result (calculate_module num1 num2 operator)]
    (println result)))

(defn -main []
  (display_module))
