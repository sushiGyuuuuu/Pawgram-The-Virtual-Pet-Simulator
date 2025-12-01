<div align="center">
  
<h1> ✨Pawgram: A Comfort Companion </h1>

<h2> Built with Java, wrapped in warmth and creativity ♡ </h2>
<h4> BY: CS-2103</h4>

---

<h3> <i>Step into Pawgram, where every pet finds a loving home🐕</i></h3>
</div>

---
<div align="justify">
<h4> Overview ₍^. .^₎⟆ </h4>
<p> Pawgram is a Java-based program designed to combat digital loneliness and provide a moment of calm by offering a simple, charming virtual pet. Its main features include interactive care routines like feeding and playing, alongside responsive animations and emotive feedback that make the pet feel alive. Pawgram solves the problem of sterile, impersonal computing environments by delivering a tiny, persistent source of comfort and joyful companionship directly on your screen, offering a gentle, positive distraction during a busy or stressful day. </p>

---
<h4> Users can: </h4>
<p>🐶 Adopt a Pet – Choose from a variety of species like cats, dogs, birds, reptiles, and more. <br>
🍖 Care for Your Pet – Feed, groom, and maintain their happiness and health. <br>
🎮 Play Mini-Games – Keep your pet entertained and earn rewards. <br>
🎁 Unlock Items – Buy toys, food, and accessories as your pet grows. <br>
🏆 Daily Challenges – Complete tasks to earn bonuses. <br>
👀 Showcase Mode – Share and show off your pet to friends. <br>
🔄 Switch Pet – Change between adopted pets anytime. <br>
</p>

---

<h3>Object-oriented Principles 𓆝 𓆟 𓆞 𓆝</h3>
<p> 
<strong>ENCAPSULATION</strong>- means bundling data (variables) and methods that operate on that data inside a class, while restricting accessibility if not included in the same package using access modifiers like protected. It protects the data and allows controlled access from outside packages through the use of getters and setters. 
  <br>
  
<strong>INHERITANCE</strong>- lets one class inherit fields and methods from another class. It promotes code reuse and creates a parent–child relationship (e.g., Dog extends Mammal or Mammal extends Pets). The Pets class encapsulates all the shared attributes and behaviors that every virtual pet must possess—such as name, species, mood levels, energy, and core interactions—while declaring abstract methods like makeSound(), move(), and eatFood() that force subclasses to provide their specific implementations. 
  <br>
  
<strong>POLYMORPHISM</strong>- allows one action to behave differently depending on the object performing it. This includes the use abstract methods, allowing different pet subclasses (like dogs, cats, or birds) to provide their own unique implementations of common behaviors—so while all pets can make sounds, a dog might bark while a cat meows, and the system can treat them uniformly as Pets objects while still executing their specific behaviors at runtime.  
  <br>
<strong>ABSTRACTION</strong>- focuses on showing only essential features while hiding unnecessary details. This is done using abstract classes and interfaces to define behavior without showing full implementation. The Pets class is declared as an abstract class, meaning it cannot be instantiated directly but instead provides a conceptual blueprint for what constitutes a virtual pet without specifying how each behavior is actually implemented. Through its abstract methods like makeSound(), move(), and eatFood(), it defines the contract of what every pet must be able to do while completely concealing the specific mechanics of how different pets will accomplish these actions.
  <br>
</p>
</div>

---
       /\_/\ 
      ( •ᴥ• ) 🐾  — Welcome, Pawkeepers!
       > 🍪      Your tiny friend awaits you!

---

<div align="center">
<h3> ── .✦ Project Structure ✦. ── </h3>
</div>

```
📂Pawgram
├── 📂src
│   └── 📂paw
│       ├── ♨️Main.java                
│       ├── 📂managers                  
│       │   ├── ♨️GameManager.java
│       │   ├── ♨️PetManager.java
│       │   └── ♨️ShopManager.java
│       ├── 📂models                    
│       │   ├── ♨️AccessoryItem.java
│       │   ├── ♨️Bird.java
│       │   ├── ♨️Cat.java
│       │   ├── ♨️Dog.java
│       │   ├── ♨️Fish.java
│       │   ├── ♨️FoodItem.java
│       │   ├── ♨️Goldfish.java
│       │   ├── ♨️Item.java
│       │   ├── ♨️Lizard.java
│       │   ├── ♨️Mammal.java
│       │   ├── ♨️Offspring.java
│       │   ├── ♨️Parrot.java
│       │   ├── ♨️Pets.java
│       │   ├── ♨️Player.java
│       │   ├── ♨️Reptile.java
│       │   ├── ♨️Snake.java
│       │   ├── ♨️ToyItem.java
│       │   └── ♨️Turtle.java
│       ├── 📂services                  
│       │   └── ♨️SaveSystem.java
│       └── 📂utils                    
│           └── ♨️PetUtils.java
│           └── ♨️UIUtils.java
└── ♨️README.md
```
---

<div align="center">
<h3> ── .✦ Folder Structure ✦. ── </h3>
</div>

- 📂 `Pawgram/` - Game folder of the project
  - 📂 `src/` - Contains all the source file of the project
    - 📂 `paw/` - Contains the source file for each functionalities of the project
      - 📂 `managers` - Contains the source code for `GameManager`, `PetManager`, and `ShopManager` 
      - 📂 `models` - Contains the source code for the player and pets (`Dog`, `Cat` etc.)
      - 📂 `services` - Contains the source code that allows for `saving` and `loading` features
      - 📂 `utils` - Contain the source code for `utilities` and `input validation` found in the project 
- ♨️ `README.md` - Includes the `overview`, `documentation`, and `instruction` for the project
---
<div align = "center">
<h3>  How to Run the Program  <br>
    ◁ |⚙⌨⚙| ▷ </h3>
</div>

---

<h2>Compilation and Running of the Program</h2>
<p>
1. Download Pawgram The Virtual Pet Simulator in github as a .zip file.
</p>

```
Pawgram-The-Virtual-Pet-Simulator-main.zip
```
<p>
2. Extract the .zip file and it should look something like this:
</p>

```
📂Pawgram-The-Virtual-Pet-Simulator-main
```
<p>
3. Navigate through the src folder
</p>

```
📂Pawgram\📂src
```
<p> 
4. Right click on the src/ folder and open in Terminal:
</p>

```
🌐Downloads\Pawgram-The-Virtual-Pet-Simulator-main\Pawgram The Virtual Pet Simulator\Pawgram\src>
```
<p>
5. Type in this command to compile:
</p>

```
🌐Pawgram The Virtual Pet Simulator\Pawgram\src> javac Main.java
```

<p>
6. If there was no errors in the compiling of the program, run the program using:
</p>

```
🌐Pawgram The Virtual Pet Simulator\Pawgram\src> java Main.java
```
---
<div align="center">
<h2>
Sample Outputs
</h2>
</div>

### Game Start

```
██████╗  █████╗ ██╗    ██╗ ██████╗ ██████╗  █████╗ ███╗   ███╗
██╔══██╗██╔══██╗██║    ██║██╔════╝ ██╔══██╗██╔══██╗████╗ ████║
██████╔╝███████║██║ █╗ ██║██║  ███╗██████╔╝███████║██╔████╔██║
██╔═══╝ ██╔══██║██║███╗██║██║   ██║██╔══██╗██╔══██║██║╚██╔╝██║
██║     ██║  ██║╚███╔███╔╝╚██████╔╝██║  ██║██║  ██║██║ ╚═╝ ██║
╚═╝     ╚═╝  ╚═╝ ╚══╝╚══╝  ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝     ╚═╝


             Your Virtual Pet Adventure Awaits!

────────────────────────────────────────────────────────────

Press Enter to continue...
```

### Main Menu

```
╔═══════════════════╗
║  Michael the Dog  ║
╚═══════════════════╝
  __      
o'')}____//
 `_/      )
 (_(_/-(_/ 

Status:
   Gender: Male
   Mood: [██████████] 100/100
   Energy: [██████████] 100/100
   Level: 1
   Health: Healthy

╔═════════════╗
║  MAIN MENU  ║
╚═════════════╝

 1. Feed Pet
 2. Play with Pet
 1. Feed Pet
 1. Feed Pet
 2. Play with Pet
 3. Put Pet to Sleep
 4. View Detailed Stats
 5. Switch Active Pet
 6. Visit Shop
 7. Open Inventory
 8. Breed Pets
 9. Manage Offspring
10. Save Game
11. Load Game
 0. Exit Game

────────────────────────────────────────
Player: Gab
Coins: 9999949
Pets: 2
Offspring: 0

Select:
```
---
<div align="center">
  
<h2> ≽^• ˕ • ྀི≼ PAWGRAMMERS ≽^• ˕ • ྀི≼</h2>
<table>
  <tr>
    <th></th>
    <th>Name</th>
    <th>Role</th>
  </tr>

  <tr>
    <td><img src="Images/Orquinaza.jpg" width="95" height="95"></td>
    <td>
      <strong>Orquinaza, Marylein</strong><br/>
      <a href="https://github.com/yamahoera" target="_blank">
        <img src="https://img.shields.io/badge/GitHub-%23121011.svg?logo=github&logoColor=white">
      </a>
    </td>
    <td>System Designer</td>
  </tr>

  <tr>
    <td><img src="IMAGE HERE" width="100" height="100"></td>
    <td>
      <strong>Perez, Gabriel Theodore</strong><br/>
      <a href="github.com/sushiGyuuuuu" target="_blank">
        <img src="https://img.shields.io/badge/GitHub-%23121011.svg?logo=github&logoColor=white">
      </a>
    </td>
    <td>Lead Developer</td>
  </tr>

  <tr>
    <td><img src="Images/Velasco.jpg" width="100" height="100"></td>
    <td>
      <strong>Velasco, Iah Shanelle</strong><br/>
      <a href="github.com/macherieshanelle" target="_blank">
        <img src="https://img.shields.io/badge/GitHub-%23121011.svg?logo=github&logoColor=white">
      </a>
    </td>
    <td>Feature Developer</td>
  </tr>

  
</table>

---

<h3> 𓇼 ⋆.˚ 𓆉 𓆝 𓆡⋆.˚ 𓇼 ACKNOWLEDGMENT 𓇼 ⋆.˚ 𓆉 𓆝 𓆡⋆.˚ 𓇼 </h3>
<p> 
  The <strong><i>Pawkeepers</i></strong> would like to express their deepest gratitude for the successful completion of this final project.
We are thankful for the effort, teamwork, and dedication we poured into developing Pawgram.

We extend our appreciation to our instructor, <strong><i>Ma'am Fatima Agdon</i></strong>, for her guidance and for teaching us the concepts that made this project possible.

Lastly, we thank <strong><i>Biskit, Chocolate, and Dixie</strong></i>, our beloved pets, for inspiring us and reminding us how meaningful real-lide pet care and companion can be.🎀
</p> 
</div>

---

<h3> 🔍References </h3>
<p>
✔️Ma'am Fatima Agdon - for guidance and supervision.<br>
✔️Object-Oriented Programming course - notes and examples.<br>
✔️GitHub Repositories - for inspiration on pet simulator project and OOP implementations.
</p>

