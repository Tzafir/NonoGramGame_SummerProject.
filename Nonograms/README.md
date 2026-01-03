# Nanogram App

A **Nanogram** (also known as Picross or Nonogram) puzzle application where players solve picture-logic puzzles by filling in cells based on numeric clues.

## 🧩 What is a Nanogram?

Nanograms are logic puzzles in which cells in a grid must be filled or left blank according to numbers given at the side of the grid. The numbers describe runs of filled cells in each row or column. Solving the puzzle reveals a hidden image.

## 🚀 Features

* Interactive nanogram puzzle grid
* Row and column clues
* Click / tap to fill or mark cells
* Mistake prevention or validation (if implemented)
* Puzzle completion detection
* Clean and minimal UI

## 🛠️ Tech Stack

* Language: **Java**
* UI Framework: **Java Swing**
* Platform: **Desktop**
* Build Tool: None (standard Java project)

## 📦 Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/your-repo-name.git
   ```
2. Navigate into the project directory:

   ```bash
   cd your-repo-name
   ```
3. Install dependencies (if applicable):

   ```bash
   npm install
   ```
4. Start the app:

   ```bash
   npm start
   ```

## 🕹️ How to Play

1. Look at the numbers on the rows and columns.
2. Fill in cells that must be shaded based on the clues.
3. Mark cells you believe should stay empty.
4. Complete all rows and columns correctly to reveal the image.

## 📁 Project Structure

```text
Nonograms/
├── src/
│   ├── NonogramApp.java          # Main application entry point
│   ├── NonogramGrid.java         # Handles grid logic and state
│   ├── NonogramLabel.java        # Row/column clue labels
│   └── NonogramSolverCheck.java  # Solution validation logic
├── README.md
└── .gitignore
```

## 🧪 Testing

```bash
npm test
```

## 📌 Roadmap

* Add multiple difficulty levels
* Puzzle generator
* Mobile support
* Timer and scoring system
* Save progress

## 🤝 Contributing

Contributions are welcome!

1. Fork the repo
2. Create a new branch (`feature/your-feature`)
3. Commit your changes
4. Open a pull request

## 📄 License

This project is licensed under the MIT License.

## 🙌 Acknowledgements

* Inspired by classic Picross/Nanogram puzzles
* Puzzle logic and UI inspired by logic puzzle games
