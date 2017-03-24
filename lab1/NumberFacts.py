def prime(n):
      isPrime = True
      for i in range(2,n-1):
        if i*(n/i) == n:
          isPrime = False
      return isPrime

def main():
      # ask user for a number
      n = eval(input("Please enter an integer: "))

      # double the number
      ndoubled = n+n
      print(n, "doubled is", ndoubled)

      # square of number
      nsquared = n*n
      print(n, "squared is", nsquared)

      # square root of number
      nsqrt = n**(0.5)
      print("The square root of", n, "is", nsqrt)

      # number divided by 7
      ndiv7a = n/7
      print(n, "divided by 7 is", ndiv7a)

      # number divided by 7.0
      ndiv7b = n/7.0
      print(n, "divided by 7.0 is", ndiv7b)

      # primality
      if prime(n):
        print(n, "is prime")
      else:
        print(n, "is not prime")

      # multiples
      multiples = [0]*9
      for i in range(0,9):
        multiples[i] = i*n
      print(multiples)
main()
