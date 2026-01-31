# 🧵 FileNewPatent

This program generates a unique Patent String for the ACME Corporation based on user input. It collects information about a patent, its inventor, and the associated institution, then performs a series of string manipulations and numeric operations to create a coded identifier that fits ACME's filing system.

---

## 📂 Files
- [`FileNewPatent.java`](./FileNewPatent.java) — main source code file containing the program logic.  
- [`SampleOutput.md`](./SampleOutput.md)— demonstrates example runs of the program with sample inputs and expected output.

---

## 🧠 Program Description
The `FileNewPatent` program prompts the user for several pieces of information required for a patent filing:

1. **Patent Name** — first and last two characters, uppercased.  
2. **Patent Type** — first character uppercased and used to replace matching letters from step 1 with the last character lowercased.  
3. **Research Cost** — dollar signs removed, rounded to nearest integer, modulo 1000, padded to 3 digits, then appended to step 2.  
4. **Inventor Name** — first name lowercased, last name uppercased, step 3 result inserted in between.  
5. **Inventor Institution** — first two letters uppercased, appended to step 4.  
6. **Institution State** — ASCII-based calculation on state letters, padded to 2 digits, appended to step 5.  
7. **Institution Zip Code** — sum of digits used to divide the zip code, modulo 1000, padded to 3 digits, appended to step 6.  
8. **ACME Item Number** — portion after the hyphen appended to step 7.  
9. **Total Length** — total length of all previous inputs (including spaces) appended after a hyphen.  
10. **Character Replacement** — all `'O'`/`'o'` replaced with `0` and `'I'`/`'i'` replaced with `1`.  

After all transformations, the program prints the final `Assigned Patent String`.

---

## ⚙️ How It Works (Step-by-Step Example)

**Step 1: Patent Name**  
Input: `Portable Hole` → Output: `POLE`  

**Step 2: Patent Type**  
Input: `Experimental Design` → Replace first letter occurrences with last letter lowercase → `POLn`  

**Step 3: Research Cost**  
Input: `$70.53` → Remove `$` → Round → Mod 1000 → Pad → Append → `POLn071`  

**Step 4: Inventor Name**  
Input: `John Smith` → first lowercase, last uppercase → Insert step 3 → `johnPOLn071SMITH`  

**Step 5: Inventor Institution**  
Input: `Purdue` → First 2 letters uppercase → Append step 4 → `PUjohnPOLn071SMITH`  

**Step 6: Institution State**  
Input: `IN` → ASCII-based calculation → Pad to 2 digits → Append → `PUjohnPOLn071SMITH24`  

**Step 7: Institution Zip Code**  
Input: `47905` → Divide by sum of digits → Mod 1000 → Pad to 3 digits → Prepend → `916PUjohnPOLn071SMITH24`  

**Step 8: ACME Item Number**  
Input: `575675-6637` → Append after hyphen → `916PUjohnPOLn071SMITH24-6637`  

**Step 9: Total Length of Inputs**  
Sum all input lengths including spaces → Append after hyphen → `916PUjohnPOLn071SMITH24-6637-72`  

**Step 10: Character Replacement**  
Replace `'O'`/`'o'` → `0` and `'I'`/`'i'` → `1` → Final Output:  
`916PUj0hnP0Ln071SM1TH24-6637-72`

---

## 👀 Sample Output

