![Lexicon Logo](https://lexicongruppen.se/media/wi5hphtd/lexicon-logo.svg)


## The Scenario
You are building a console-based contact management application.

Think about what a contact manager should do and how a user would interact with it — then build it.

**Create `ContactApp.java`** inside `src/main/java/se/lexicon/`.  
Commit regularly as you make progress.

- [Objectives](./Arrays-Collection-Workshop.md)



- **Functionality** — what operations should a contact manager support? What would a user expect to be able to do?
- **Data** — what information does a contact hold? How should that be represented given your chosen data structure?
- **Data structure** — which structure fits the way contacts will be stored and accessed? Consider the trade-offs.
- **Constraints** — what rules should the system enforce? Think about what invalid states should never be allowed.
- **Code organisation** — how will you separate concerns? Each operation should have a clear home in your code.


Data structure map vs class entity class!
map have only key and value pair while entity class can have multiple variables.

* [x] search for person by name
* [x] add new contacts
* [x] remove a contact
* [x] edit contact
* [x] sort in alphabetic order
* [ ] brows all contacts in alphabatic order
* [x] search by first letter
* [ ] compare hash on add
* [ ] build the terminal ui

## Optional Challenges

Once the core app works, try extending it:
- create a new branch for each challenge
- commit your work regularly
- merge your branch into the main branch when you're done

---

### Challenge 1 – Sort Contacts

Display all contacts sorted alphabetically by name.

---

### Challenge 2 – Unit Tests

Write unit tests for each data-access operation: add, search, delete, and update.

- Use JUnit 5 and place tests in `src/test/java/se/lexicon/`
- Each method should have at least one positive test case and one negative test case

---

### Challenge 3 – File I/O

**Export:** Save all contacts to a file when the user exits.  
**Import:** Load contacts from that file automatically when the app starts.

Support at least one format:
- Plain text — one contact per line, in a format that matches your storage approach
- CSV
- Excel (`.xlsx`)
