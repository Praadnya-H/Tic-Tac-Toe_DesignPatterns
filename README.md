# Tic-Tac-Toe Game 🎮

## 🚀 Features
- Supports **N x N** board (user-defined size).
- Allows **multiple players** (up to N-1).
- Players can be **Human or Bot** (Bots have random names and symbols).
- **Turn-based gameplay** with input validation.
- **Multiple win conditions** (Row, Column, Diagonal, Anti-Diagonal).
- Uses **Design Patterns** for maintainability and scalability.

---

## 🏗️ Design Patterns Implemented

### 1️⃣ **Factory Pattern 🏭** (Player Creation)
- Used to dynamically create **Human** and **Bot** players.
- Ensures **scalability** by decoupling player creation logic.

### 2️⃣ **Strategy Pattern 🎯** (Win & Draw Checking)
- Each win condition (Row, Column, Diagonal, Anti-Diagonal) is a separate strategy.
- The **draw check** is also a separate strategy.
- Allows easy **extension** of new rules without modifying the game logic.

### 3️⃣ **Observer Pattern 👀** (Game State Updates)
- Observers (e.g., scoreboards, UI elements) get notified when the game state changes.
- Implements a **publisher-subscriber model** for better separation of concerns.

---

## 🏆 Win Strategies Implemented
1. **Row Win Strategy** - A player wins by filling a row.
2. **Column Win Strategy** - A player wins by filling a column.
3. **Main Diagonal Win Strategy** - A player wins by filling the main diagonal.
4. **Anti-Diagonal Win Strategy** - A player wins by filling the anti-diagonal.
5. **Draw Strategy** - Checks if the board is full without a winner.

---

## 📌 How to Play
1. Run the program(Main.java) and enter **board size (N)**.
2. Choose **number of players** (≤ N-1), **type of players**, **name and symbol (if human players)**.
3. Game starts with turn-based play.
4. **Bots make random moves**, while humans input row/column indices.
5. The game **announces the winner or a draw** based on strategies.

---
