# existential_forgery
This implementation of cryptographic existential forgery solves two problems given e = n, an RSA public modulus. The first problem is: without factoring n, provide a message m together with its RSA signature, theta, such that m ends with 2017 in base 10.  The second is: without factoring n, check that a given exponent, e' is also valid to verify signed messages.
