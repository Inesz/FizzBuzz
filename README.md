# FizzBuzz

## How to run
1. Run Main class.
2. Run tests.

## Solution description
Api enables:
- set custom parameters (divisors and output) or use predefined FizzBuzz parameters.
- set custom loop parameters (begin, end, step) or use predefined from 1 to 100 numbers.

## Problem description

For all numbers from 1 to 100 (inclusive):
* if it is divisible by 3, output "Fizz"
* if it is divisible by 5, output "Buzz"
* if it is divisible by neither, output the number

Expected output after running the program:
<br/>1
<br/>2
<br/>Fizz
<br/>4
<br/>Buzz
<br/>...

## Task

### Requirement

1. Use Java.
2. Keep track of your work/changes in a Git repository. The commit history is
   important to show progress/evolution.
3. Prior to the interview provide a link to the repository (in case of a public
   GitHub one for instance) or a ZIP archive containing a copy of your local
   repository.

### Part 1

Implement an application for above problem description.

### Part 2

Prove its correctness using unit testing (for all cases).

### Part 3

Update your implementation to receive as input a `Map<Integer, String>`, where
the keys are the divisors and the values are the expected output. For the
initial problem this would be `Map.of(3, "Fizz", 5, "Buzz)`.
