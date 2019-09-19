# Substitution-Cipher

Software: Eclipse Java Oxygen, Version: Oxygen.2 Release (4.7.2)
Programming Language: Java Language
Compiler: jdk-9.0.4
Step 1: Initialisation:
- We have Initialized character array- key to store the key, alphabet variable that holds a-z, space, . ,comma making the variable alphabet size length equal to 29 characters. Further, the plaintext is defined as string and converted to character array.
Step 2: Shuffle Array Method- Call ShuffleArray Method
- Further, in this substitution cipher program we need a permutated key, so we have used the ThreadLocalRandom.current() to generate random values from the assigned alphabet array defined earlier.
- This random generated value is swapped with the value positioned at the end of the array. The step is repeated till the first element is swapped. Accordingly, the permutated key is generated.
Step 3: Encryption- Call Encryption Method.
- This method takes plaintext and the key as arguments.
- The element is matched with position at (alphabet[j] == plaintext[i]) where i is from 1 to plaintext length and j is from 0 to 29 alphabet.
- Further, if the required element is present at both the position, alphabet array and the plaintext array, then we print the element stored in the key at position j. This will help map the alphabet defined array with the key array.
- The method will return ciphertext.
Step 4: Decryption- Call Decryption Method
- The ciphertext and the random permutated key is passed for decryption.
- We try to match the element at key array value with the encrypted array value, and return the element stored at the same alphabet array position.
- This method will return the plaintext.
