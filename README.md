### Table of content

[1. Introduction](#1-introduction)

[2. Design](#2-design)

[2.1. Interactive Periodic Table](#21-interactive-periodic-table)

[2.2. Limiting Reagent Calculator](#22-limiting-reagent-calculator)

[2.3. Mass-to-Mole Converter](#23-mass-to-mole-converter)

[2.4. Equation Balancer](#24-equation-balancer)

[2.6. Software](#26-software)

[2.6.1. IDE and Tools](#261-ide-and-tools)

[2.6.2. Targeted Platform](#262-targeted-platform)

[2.6.3. Packages](#263-packages)

[3. Main GUI](#3-main-gui)

[3.1. Main Page](#31-main-page)

[3.2. Dark Mode](#32-dark-mode)

[4. Conclusion](#4-conclusion)

  # 1. Introduction

  ##  **1.1 Explanation** 

QuickChemistry is a chemistry homework helper. When doing chemistry
homework, certain operations come up at almost every problem and become
very repetitive. They also often take up much needed space to solve the
problem. These operations are searching the periodic table, finding the
limiting reagent, balancing equations, and converting between moles and
mass or vice versa. This application aims to take these operations that
we know how to do since they are so frequent and give people a bit of
reprieve. This helps save some time for students that are studying and
helps get them to the meat of the problem they want to study much
quicker. The application will open on a main page to select which one of
the 4 operations you want perform. This is effectively 4 applications
connected by this main page.

The periodic table part of the application shows key properties of
selected atoms to help with calculations, such as the atomic number,
symbol, name, atomic mass, melting point, and boiling point. These
numbers are often kept in many different tables when given by the
teacher. We aim to bring them all in one place. More could even be
added, should we have the time and space on the screen. The entire
periodic table will also be displayed since the shape of the periodic
table holds particularly important information as well, such as the
families of each atom.

The limiting reagent part takes an equation and the amount of each
reactant to find the limiting reagent. This is often asked in exercises
and can be quite tedious. It is also an essential part of solving
problems when an amount of product needs to be found.

The equation balancer is the most complicated part of the application
since it is often done by trial-and-error by students. Balancing an
equation means that we ensure that there is an equal amount of every
atom on each side of the equation. Atoms aren't just magically created.
This step helps find the molar ratio of the components in the equation,
which is at the core of stoichiometry.

The converter part is pretty straight forward. It either takes moles and
brings them to mass or the other way around for any given atom or
molecule. This is one of the most common tasks in problem solving as it
is repeatedly done throughout the problem. Also, if you select
moles-to-mass and want 1 mole of something, it becomes a convenient
molar mass calculator.

##  **1.2 Importance** 

As science students, we have all gone through our fair share of
chemistry classes. Certain aspects of chemistry crop up again and again:
balancing equations, calculating limiting reagents, search for
information on a periodic table and converting moles to mass and back
again. These aspects eventually become rote, but habit does not make
them any less time consuming. The chemistry homework helper is meant to
reduce the time spent on certain aspects of a problem so that the user
may focus on the most important parts. In relying on a computer, the
possibility of small mistakes in these seemingly inconsequential
chemistry calculations also diminishes. As such, this is meant to be the
four-in-one tool that any secondary and CEGEP student wishes for.

This project is also important for us, the programmers, as well. As
students in a computer science program, we get the minimum of chemistry
education possible. However, chemical reactions and a modicum of general
knowledge about chemistry goes a long way and can prove highly important
in the future. Taking whatever knowledge we have and focusing on it,
distilling it to be able to create an algorithm capable of replicating
it, allows us to understand these concepts in a way few other students
do, and in a way that we will most likely remember for a long time.

Similarly, this project allows us to focus on every aspect of coding we
have learned so far. The various aspects of the chemistry homework
helper enable us to focus on specific concepts as well: the periodic
table has a heavy focus on interactive graphics, the equation balancer
and limiting reagent problems have a heavy focus on mathematics and
manipulating the String java class. This project combines three
different concentration courses -- chemistry, mathematics and
object-oriented programming -- to result in a excellent tool and much
experience for the future.

##  **1.3 Objectives** 

The chemistry homework helper, or QuickChemistry, is programmed and
built to accomplish four main goals. These objectives, if reached, will
assure a quality program.

### 1.3.1 Efficiency

The four components of QuickChemistry, the interactive periodic table,
the limiting reagent calculator, the mass-to-mole converter, and the
equation balancer should all be working smoothly together. The
interactions with the multiple tools offered in the helper should have
little to no latency and be efficient.

### 1.3.2 Intuitiveness

QuickChemistry and its many features should be easy to use; a first-time
user should be able to use the program without frustration. Furthermore,
there should not be a lot of instructions given on how to use the
program, it should be intuitive.

### 1.3.3 Usefulness

Every tool of the chemistry helper should be programmed into the app to
help students complete their chemistry homework. It should contain
features that accomplish task that students are often required to do.
Altogether, QuickChemistry should be useful for the chemistry students.

### 1.3.4 Accuracy

The information provided in the QuickChemistry, for example in the
interactive periodic table, the information about each element should be
accurate, equations should be correctly balanced and the answers to the
limiting reagent calculator and mass-to-mole calculator should be
accurate.

# 2. Design

##  **2.1 Interactive Periodic Table**

One tool that students in a chemistry class are frequently using is a
periodic table; it provides many useful information that are import when
solving problems. Our chemistry homework helper will have one that will
be made interactive to engage students and save them important time when
looking for properties or information of a specific element. To save
space and have a more intuitive interface, it was determined that a
basic periodic table containing only the atomic numbers and the symbols
of each element will be displayed. The periodic table will be contained
in a grid of 18 columns and 10 rows: 7 rows, a buffer row and 2 more
rows. To the left of this grid, will be displayed an information box in
which more specific information about an element such as its name,
atomic mass, melting point and boiling point in addition to the atomic
number and symbol. When no information is displayed in the information
box, a short informative text explaining how a periodic table is meant
to be interpreted will be shown. For aesthetic purposes, each element
will have its symbol in the middle and its atomic number, smaller, will
be at the top of the box. Furthermore, the lines of the grid will be
used as negative space, in other words, the lines will be large and the
same color as the background. The basic style of the interactive
periodic table is shown below.

All the information about each element will be contained in a text file
\[table.txt\] and will be accessed when the user requests it. The file
will be formatted as followed:

`atomicNumber,symbol,name,atomicMass,meltingPoint,boilingPoint` 

To access each element\'s information, a method, tableDisplay() will be
called upon hovering over a box in the grid, the atomic number that is
displayed in this box will be used to scan the file until the
appropriate line is reached; the atomic number, which is also the number
of the appropriate line of the element will be passed in the method and
will indicate a specific loop how many times to run and will stop when
it reaches the element\'s information which are on that line.
Afterwards, the information contained on this line will be displayed in
the information box. When the mouse will leave this box, the information
box will be reset and displayed its default text until another
box/element is selected.

Efficiency of the tableDisplay() method will be discussed later when
discussing the efficiency considerations of the elementBrowser class.

##  **2.2 Limiting Reagent Calculator**

### Theory

The limiting reagent part of this application calculates the limiting
reagent of the given chemical reactions. When a chemical reaction
occurs, you most often won't have the exact amount of reactants you
need. The limiting reagent is the limiting factor of the reaction. It's
the ingredient that will force the least product to be created. For
example, let's take the combustion of methane: CH4 + 2O2 = CO2 + 2H2O.
If performed in open air, the limiting reagent would be methane, since
there is "infinite" oxygen available around to use.

### Objects

There are 5 types of objects in this part of the application. 3 of which
are used to process the equation.

-   When a Molecule object is created, it takes the molecules with their
    molar ratio. It removes the molar ratio and stores it as a variable.
    The raw name is also stored as a variable to later identify the
    molecule. The constructor then breaks the molecule into individual
    atom types and creates an array of Atom objects with those atoms.

-   When an Atom object is created, the constructor triggers a "setAtom"
    method that takes the String is the atom symbol from the Molecule
    constructor and removes the "subscript" that is not subscript here
    due to formatting limitations. The "subscript" is stored as a
    variable. The method then searches through the periodic table to
    find the atomic number and atomic mass which are stored as
    variables.

-   The PeriodicTable object searches through the periodic table text
    file when the application is launched and replicates the file into a
    convenient 2-dimessional String array. The array can then be
    searched for any necessary information using the atomic number as
    the index and the appropriate column index.

The 2 other objects are named Moles and Mass. They run the limiting
reagent calculations according to whether the user chooses to use moles
or mass. They each have a constructor triggered for each new equation
and a run() method to run their calculations.

The code logic for the run() method in each should look a little like
this. The "current molecule product amount" is how much product that
molecule can produce following the equation molecule. We are looking for
the smallest product amount, since that is what will limit the reaction.
We will find the product amount for the first product molecule in the
equation as it is the easiest to compute. We could search for the
smallest product molar ratio, but that would hurt our processing time.

    for (every reactant molecule){

       if (current molecule product amount \< temp product amount)

          temp = current molecule product amount;

          tempIndex = current molecule index;

       else

          continue;

### Equation Processing Algorithm

The equations should be written according to the following formatting:
`2Fe2O3 + 3CO = 2Fe + 3CO2`. The formatting will be verified and give an
error to reenter the equation if it does not follow the rules. Spaces
need to be added between math symbols. Molecules cannot have spaces
between them. Atoms with symbols containing more than one character
should have only the first letter capitalized. The application will also
throw an exception if the atom does not exist. The equation will be
broken down to extract all the necessary information into manageable
pieces according to the following graph.

### Efficiency

Information is stored by putting arrays of Atom in arrays of Molecule.
It can be thought of as: an equation contains a list of molecules; each
molecule contains a list of atoms. Processing the string of molecules
would have an O(n) time complexity since there is only one loop needed
and there is no need to reach for the atoms. When all atoms are
processed, the time complexity would be O(n^2^) since a nested loop is
required to get all the atoms of every molecule. All searching methods
will use linear search methods, which have an O(n) time complexity.

### Features and Limitations

This part of the application runs on a loop. You can try an equation,
then scrub it and try another one. There are two ways to find the
limiting reagent, either with the actual moles or by the mass. Each
process is an object with a run() method. Each follow the same principle
of finding the molecule that generates the least product, therefore
limiting the reaction. The moles do it directly with molar ratios and
the mass converts the given masses into moles and then uses molar
ratios.

An optional feature to add if we have the time would be to add an option
for "unlimited" reactants such as the methane combustion example. If
time is too limited, we will ask to input a disproportionally high
number like 10 000 000 to force a limiting reagent down.

### GUI

The window for this application will start by displaying a text field to
give the equation. The equation will then be processed to extract the
molecules. Each reactant molecule will then be displayed with a text
field to input the mass or moles, depending on the option chosen in the
adjacent menu. The limiting reagent will be calculated and then
highlighted to show the result. The window will follow something like
the following mock-up but following the application color scheme.


### UML Diagram


##  **2.3. Mass-to-Mole Converter**

For students of this generation, homework can take up a lot of time,
often for no good reason. Students coming out of secondary school
already know how to convert moles to grams or vice versa but must still
take time to do it in every assignment. This converter's goal is to
allow students to quickly perform the operation and move on to more
important parts of the homework. If the student wishes to turn moles to
grams, the program will simply multiply the inputted number of moles by
the molar mass of the element or compound selected to give an answer in
grams. If the student wishes to convert grams to moles, the program will
simply divide the mass in grams given by the molar mass to give an
answer in moles.

The mass to mole converter will have two modes: mass-to-mole, and
mole-to-mass. For the former, the user will input the element or
compound that they are converting in a text field (ex: H2O), then they
will enter an amount in grams in another text field, click a "convert"
button and the program will give the corresponding answer in moles. For
the latter, the user will again input the element or compound, but will
enter a number of moles in the next text field, then click "convert",
and the program will give the corresponding answer in grams.

Because of how the code will process the element or compound, the
converter will not work with coefficients place in front of a symbol
(ex: 2H2O would not work, but H2O would work).


elementBrowser is a class that will allow the program to look through a
text file and get values for the element of the periodic table.

All methods will take in an integer equivalent to an element's atomic
number, the program will then look in the text file for the line with
the corresponding index, create a string array with the text in the line
and return a different position of the array depending on which method
is called. For example, if getMolarMass is called, the method will
return the 4^th^ position in the array.

To improve on efficiency, the program looks through a text file that
already has all the elements listed with their respective properties
instead of creating objects with code when it starts, only looking
through the text file when prompted. This way there are no elements
created for nothing and less pointless work for the program to execute,
speeding up the efficiency.

The UI for the converter will have two appearances, one for mass-to-mole
conversion and one for mole-to-mass conversion, to switch from one to
the other, the user will have to click on a button. The images below are
a rough estimate of what the UI will look like.


##  **2.4. Equation Balancer**

Balancing a chemical equation is often the first step in any chemistry
assignment. Doing it by hand, however, involves using a trial-and-error
method that can be time-consuming and prone to mistakes. The Equation
Balancer part of QuickChemistry provides the students with the balanced
version of any equation they input, as long as it can be balanced and is
inputted as specified. It can be used to save time when working on
problems or simply to double-check a result that the user calculated by
hand.

### Theory

There are two known methods for balancing equations. The first is the
trial-and-error method, which involves adding coefficients that seem
correct to the appropriate places through educated guesswork. This
method is the one used most often when balancing equations by hand.
However, it may prove inefficient and frustrating to use at times,
especially when balancing equations with multiple compounds. An example
of the first method is provided below:

$Na_{2} + O_{2} \rightarrow Na_{2}O$ This equation is unbalanced. A *2*
will be added to the first term to attempt to balance it.

$2\ Na_{2} + O_{2} \rightarrow Na_{2}O$ This remains unbalanced. A *2*
will be added to the last term to attempt to balance it.

$2\ Na_{2} + O_{2} \rightarrow 2\ Na_{2}O$ This remains unbalanced. The
coefficient of the first term will be changed to a *4*.

$4\ Na_{2} + O_{2} \rightarrow 2\ Na_{2}O$ The equation is balanced.
There is an equal number of atoms present before and after the reaction
occurs.

For complex equations, this method becomes tedious and time-consuming.
There is a second, lesser known and lesser used method that can be
applied to those situations. Using linear algebra, an equation can be
transformed into a linear system, from which a matrix can be obtained
and then solved by Gaussian elimination. To the best of my knowledge and
according to my research, there are two types of equations for which
this method will work. If an equation has the same number of terms as it
has different elements or if an equation has one more term than it has
different elements, the matrix can be formed and solved. Any other
configuration will not provide an adequate solution. Two examples of a
linear system will be provided below.

##### Example 1 

$$H_{2} + O_{2} \rightarrow H_{2}O$$

This is an unbalanced equation. It contains two different elements, *H*
and *O*, and three terms, *H~2~*, *O~2~* and *H~2~O*. To set up the
matrix, each term is assigned a variable as a coefficient.

$${\mathbf{a}\text{\ H}}_{2} + {\mathbf{b}\text{\ O}}_{2} \rightarrow {\mathbf{c}\text{\ H}}_{2}O$$

Then, for each element, its occurrences in each term are counted. This
yields the same number of equations as elements. It might be useful to
consider the arrow ($\rightarrow$) as an equal sign (=) for mathematical
simplicity. As such:

$${H:\ 2\mathbf{a}\  + \ 0\mathbf{b}\  = \ 2\mathbf{c}
}{O:\ 0\mathbf{a}\  + \ 2\mathbf{b}\  = \ 1\mathbf{c}}$$

For simplicity, all unknown will be passed to the same side of the equal
sign (=). This yields two equations for three unknowns, which means that
there are multiple solutions. In order to circumvent this, an arbitrary
row of zeros will be added to the system. The system thus becomes:

$$H:\ 2\mathbf{a}\  + \ 0\mathbf{b}\  - \ 2\mathbf{c} = 0$$

$$O:\ 0\mathbf{a}\  + \ 2\mathbf{b}\  - \ \mathbf{c}\  = \ 0$$

$$Arbitrary:\ 0\mathbf{a} + 0\mathbf{b} + 0\mathbf{c} = 0$$

Which can be expressed as a matrix wherein each column represents an
unknown and each row represents an element:

$$\begin{matrix}
2 & 0 & - 2 & 0 \\
0 & 2 & - 1 & 0 \\
0 & 0 & 0 & 0 \\
\end{matrix}$$

Generally, this is where the matrix would be reduced by Gaussian
elimination, but in this case, it is unnecessary. The next step is to
perform back-substitution. The equations that can be obtained from this
matrix are:

$${2\mathbf{a} - 2\mathbf{c} = 0
}{2\mathbf{b} - 1\mathbf{c} = 0
}{0\mathbf{c} = 0}$$

Which, for the back-substitution, will be transformed as to isolate the
respective variables such that:

$${\mathbf{a =}\frac{\mathbf{2}\mathbf{c}}{\mathbf{2}}\mathbf{= c}
}{\mathbf{b} = \frac{1\mathbf{c}}{2} = \frac{1}{2}\mathbf{c}
}{0\mathbf{c}\  = \ 0}$$

The result of matrices used in this method will always yield a
homogenous solution, which is not a usable answer. The final value must
be readjusted. ***c*** will be set to be equal to 1. As such:

$${\mathbf{a = c = 1}
}{\mathbf{b} = \frac{1}{2}\mathbf{c} = \frac{1}{2} \times 1 = \frac{1}{2}
}{\mathbf{c}\  = \ 1}$$

By convention, all coefficients of a chemical equation must be positive
integers. The previous results are multiplied by the lowest common
multiple of all denominators of all fractions of the solution. In this
case, there is only one fraction, and its denominator is 2. All elements
are thus multiplied by two.

The solution is thus
$\mathbf{a} = 2,\ \ \mathbf{b} = 1,\ \ \mathbf{c} = 2$. The balanced
equation is $2\ H_{2} + O_{2} \rightarrow {2\ H}_{2}O$.

##### Example 2

$$K_{4}\text{Fe}\left( \text{CN} \right)_{6} + H_{2}SO_{4} + H_{2}O \rightarrow K_{2}SO_{4} + FeSO_{4} + \left( NH_{4} \right)_{2}SO_{4} + CO$$

This is an unbalanced equation. It contains seven different elements and
seven terms. To set up the matrix, each term is assigned a variable as a
coefficient and each element's occurrences are counted. All unknowns are
passed to the same side of the equation. A matrix can be created. As
there are an equal number of terms and elements, adding an arbitrary row
is unnecessary.

$${\mathbf{a}\text{\ K}}_{4}\text{Fe}\left( \text{CN} \right)_{6} + {\mathbf{b}\text{\ H}}_{2}SO_{4} + {\mathbf{c}\text{\ H}}_{2}O \rightarrow {\mathbf{d}\text{\ K}}_{2}SO_{4} + \mathbf{e}\text{\ FeS}O_{4} + {\mathbf{f}\ \left( NH_{4} \right)}_{2}SO_{4} + \mathbf{g}\text{\ CO}$$

$${K:\ 4a - 2d = 0
}{Fe:\ a - e = 0
}{C:\ 6a - g = 0
}{N:\ 6a - 2f = 0
}{H:2b + 2c - 8f = 0
}{S:\ b - d - e - f = 0
}{O:\ 4b + c - 4d - 4e - 4f - g = 0}$$

$$\begin{matrix}
4 & 0 & 0 & - 2 & 0 & 0 & 0 & 0 \\
1 & 0 & 0 & 0 & - 1 & 0 & 0 & 0 \\
6 & 0 & 0 & 0 & 0 & 0 & - 1 & 0 \\
6 & 0 & 0 & 0 & 0 & - 2 & 0 & 0 \\
0 & 2 & 2 & 0 & 0 & - 8 & 0 & 0 \\
0 & 1 & 0 & - 1 & - 1 & - 1 & 0 & 0 \\
0 & 4 & 1 & - 4 & - 4 & - 4 & - 1 & 0 \\
\end{matrix}$$

The matrix is then reduced by Gaussian elimination. The same two steps
are repeated for each row:

1.  If the leading number in the row is equal to zero, switch it with
    another row. In this case, it is unnecessary.

2.  Multiply the current row by $\frac{- m}{x}$ and add it to a row
    below (*m* being the leading number below *x*, which is the current
    leading number).

*x* is 4, *m* is 1. The first row is multiplied by $\frac{- 1}{4}$

$$\begin{bmatrix}
4 & 0 & 0 & - 2 & 0 & 0 & 0 & 0 \\
\end{bmatrix} \times \frac{- 1}{4} = \begin{bmatrix}
 - 1 & 0 & 0 & \frac{1}{2} & 0 & 0 & 0 & 0 \\
\end{bmatrix}$$

and added to the second row

$$\begin{bmatrix}
 - 1 & 0 & 0 & \frac{1}{2} & 0 & 0 & 0 & 0 \\
\end{bmatrix} + \begin{bmatrix}
1 & 0 & 0 & 0 & - 1 & 0 & 0 & 0 \\
\end{bmatrix} = \begin{bmatrix}
0 & 0 & 0 & \frac{1}{2} & - 1 & 0 & 0 & 0 \\
\end{bmatrix}$$

Which results in:

$$\begin{matrix}
4 & 0 & 0 & - 2 & 0 & 0 & 0 & 0 \\
0 & 0 & 0 & \frac{1}{2} & - 1 & 0 & 0 & 0 \\
6 & 0 & 0 & 0 & 0 & 0 & - 1 & 0 \\
6 & 0 & 0 & 0 & 0 & - 2 & 0 & 0 \\
0 & 2 & 2 & 0 & 0 & - 8 & 0 & 0 \\
0 & 1 & 0 & - 1 & - 1 & - 1 & 0 & 0 \\
0 & 4 & 1 & - 4 & - 4 & - 4 & - 1 & 0 \\
\end{matrix}$$

This operation is repeated for all subsequent rows until every entry
below x is a 0.

$$\begin{matrix}
4 & 0 & 0 & - 2 & 0 & 0 & 0 & 0 \\
0 & 0 & 0 & \frac{1}{2} & - 1 & 0 & 0 & 0 \\
0 & 0 & 0 & 3 & 0 & 0 & - 1 & 0 \\
0 & 0 & 0 & 3 & 0 & - 2 & 0 & 0 \\
0 & 2 & 2 & 0 & 0 & - 8 & 0 & 0 \\
0 & 1 & 0 & - 1 & - 1 & - 1 & 0 & 0 \\
0 & 4 & 1 & - 4 & - 4 & - 4 & - 1 & 0 \\
\end{matrix}$$

The operations are then repeated for each row. *x* will always be one
column to the right of what it was previously. As the next *x* in this
example will be zero, and the steps detailed above repeat. The second
row will be switched with the fifth, as it is the first one which has a
nonzero number in that column, and that row will then be multiplied and
added to the next, etc.

Following these steps will reduce the matrix to:

$$\begin{matrix}
4 & 0 & 0 & - 2 & 0 & 0 & 0 & 0 \\
0 & 1 & 1 & 0 & 0 & - 4 & 0 & 0 \\
0 & 0 & 1 & 1 & 1 & - 3 & 0 & 0 \\
0 & 0 & 0 & 1 & 1 & - 3 & 1 & 0 \\
0 & 0 & 0 & 0 & 1 & - 1 & \frac{1}{3} & 0 \\
0 & 0 & 0 & 0 & 0 & 2 & - 1 & 0 \\
0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\
\end{matrix}$$

Which can be expressed as:

$${4a - 2d = 0
}{b + c - 4f = 0
}{c + d + e - 3f = 0
}{d + e - 3f + g = 0
}{e - f + \frac{1}{3}g = 0
}{2f - g = 0
}{0g = 0}$$

Which will be transformed into:

$${a = \frac{1}{2}d
}{b\  = \ 4f - c
}{c = 3f - d - e
}{d = 3f - g - e
}{e = f - \frac{1}{3}g
}{f = \frac{1}{2}g
}{0g = 0
}$$

$${a = \frac{1}{6}
}{b\  = \ 1
}{c = 1
}{d = \frac{1}{3}
}{e = \frac{1}{6}
}{f = \frac{1}{2}
}{g = 1}$$

As there are fractions present, the lowest common multiple of all
denominators (6, 3, 6, 2: lowest common multiple is 6) will be
calculated, and all values will be multiplied, thus, the solution is
$a = 1,\ \ b\  = \ 6,\ \ c = 6,\ \ d = 2,\ \ e = 1,\ \ f = 3,\ \ g = 6$.
The balanced equation is
$K_{4}\text{Fe}\left( \text{CN} \right)_{6} + {6\ H}_{2}SO_{4} + {6\ H}_{2}O \rightarrow {2\ K}_{2}SO_{4} + FeSO_{4} + {3\ \left( NH_{4} \right)}_{2}SO_{4} + 6\ CO$

The method detailed above might seem long and overly complicated (and it
is, when done by hand), but it is also the only method of balancing
chemical equations that can be transposed into an algorithm, especially
if that algorithm is required to have flexibility and be capable of
handling somewhat complex equations. Guesswork cannot be easily
programmed, but matrices and mathematical operations can.

Note: Gauss-Jordan elimination can be used in most cases of matrix
computation. However, as seen above, the end result of the reduction of
a matrix used for this purpose will always yield a final row of zeros,
and a final column of zeros, which renders Gauss-Jordan elimination
useless as it will only yield a matrix akin to an identity matrix, which
will not provide the results needed.

### Algorithm

The algorithm itself will be divided into five parts. The equation will
first be inputted into a textfield by the user, following specifications
outlined in 2.4.4. *Features, Limitations and Constraints*. The
equation will then be analyzed in order to set up the matrix. The matrix
must then be reduced to row echelon form, which will necessitate code to
treat the back-substitution. The results must then be outputted.

#### Input

The user will input an equation as a string in a textfield, according to
the instructions they will be presented with (detailed in 2.4.4). Then,
quite simply, all spaces in the string henceforth referred to as
*inputtedEquation* will be replaced with nothing ("") and passed into
the method *buildMatrix(String equ)*, found in the *Matrix* class. This
part of the algorithm has a time complexity of O(1), as it uses no loops
and only uses the predefined java method *replaceAll()* in the *String*
java class.

The initial GUI will consist of two textfields and a box containing
instructions. One of the textfield will be awaiting input, and the other
will be empty until the result is displayed. A button will also be
present to signal that the user has finished inputting the equation.

#### Building the Matrix

Once the *buildMatrix(String equ)* method is passed the
*inputtedEquation*, it will split the string at the equal sign (=) which
is meant to replace the right arrow traditionally used when writing
equations. This will yield a String array of size 2 wherein the first
entry will be a string which contains all reagents, and the second entry
will be a string which contains all products. The first entry will be
further split at the plus signs (+) to yield a second array, one which
contains each term on the reagents' side. The same will be done of the
second entry. A string array of length equal to the sum of the terms on
the reagents' side and on the products' side will be created. The
reagents' array will be copied into this last array as is. The next
index following the last term copied will be saved as a class variable
(*int productBegins*) as the beginning of the products' side, to which
the terms of the products' array will also be copied. This final array,
called *termsArray*, will be used for the creation of the matrix as well
as the output. As such, it will be passed to the class variable
*equationTerms.* This part of the process has efficiency O(n), as the
arrays are copied through two non-nested loops, one for each array
copied ($T(n)\  = \ O(n)\  + \ O(n)\  = \ O(n)$).

The next part begins analysing the content of the *termsArray*. The
current method (*buildMatrix(String equ)*) will pass the *termsArray* to
a method named *makeReadable(String\[\] arr)*, which will modify each
entry in the array so that all elements who do not have subscripts will
be followed by a 1. This part has efficiency O(n^2^), as there is a
nested loop that will scan each character of each term, contained inside
a loop scanning each term of the array
($T\left( n^{2} \right) = n \times n = n^{2} = O\left( n^{2} \right)$).

Example:

$${H2O\ \text{becomes}\ H2O1
}{K4Fe(CN)6\ becomes\ K4Fe1(C1N1)6}$$

The *makeReadable(String\[\] arr)* will then pass *termsArray* to
*containsParenthesis(String\[\] arr)*, which will determine whether any
of the entries in the array contain parentheses. If so, it will modify
the respective entries to ensure proper readability in the next step. It
will separate the respective term into the parts containing parentheses
and those that do not, while keeping all subscripts attached. The
subterm containing the parenthesis will be separated into the respective
elements, and the subscripts attached to them will be multiplied by the
subscript outside of the parentheses. This part has efficiency O(n^3^),
as there is a loop multiplying the elements inside of the parentheses by
the coefficient inside of a loop that passes through all subterms
created in this method which is contained in a method scanning all terms
of the *termsArray*.

Example:

$$K4Fe1(C1N1)6\ becomes\ K4Fe1\ and\ (C1N1)6\ becomes\ K4Fe1\ and\ C6\ and\ N6\ becomes\ K4Fe1C6N6\ $$

Afterwards, the *buildMatrix(String equ)* continues by listing each
different element in an arrayList\<String\>. The coefficients are
ignored in this case. This part will have efficiency O(n^2^), as a loop
scanning each character of the terms will be contained inside the loop
scanning *termsArray*.

Once the elements array is completed, a final verification must be done.
If the size of *termsArray* minus the size of elements array is larger
than one, the matrix will not have a solution. an error message is then
sent to the user.

Now, the matrix can be created. A square array of the same size as
*termsArray* will be initialized to contain all zeros. Then, term by
term, the occurrences of each element in a term will be counted and the
values inputted directly into the matrix. In essence, for a term of
index *j*, an element will be found and registered as a temporary
variable. A linear search method will find the index *i* of the
respective element in the elements arrayList. The coefficient of the
temporary element (i.e. the number following the element) will be added
to the number found in the array at the *i*th row and *j*th column. This
will be repeated for every element in every term of the *termsArray*.
This matrix will be passed to the class variable *Fractions\[\]\[\]
matrix.* This part of code ends the process of building the matrix and
has efficiency O(n^3^), as a loop scanning through *termsArray* will
contain a loop scanning the characters of each terms, and for each
character, a linear search of efficiency O(n) will be performed.

#### Reducing the Matrix

Reducing the matrix involves repeating the same two actions for every
row except the final row. This code will be found in the method
*solveMatrix()*, which will manipulate the class variable
*Fractions\[\]\[\] matrix*. The algorithm must first verify that the
first number is a leading number (i.e. the first number in a row that is
not a zero -- this will be saved as a variable for future purposes). If
it is zero, the row must be swapped with the next row that does not hold
a zero in that column. Following that, all entries under the leading
number must be manipulated to become zero. As detailed previously, this
involves multiplying the row by $\ \frac{- m}{x}$ and adding it to the
following rows, where (*m* is the next leading number and *x* is the
current leading number). This is repeated for each row that does not
hold a zero underneath the leading number. Row by row, the matrix will
be reduced to row echelon form, which will enable the next part of the
algorithm. The efficiency for this part is O(n^3^), as the two
operations, both of which involve scanning various rows to find
information and then manipulating the values in each column of that row
-- hence containing loops within loops therefore an efficiency of
O(n^2^), are contained within a larger loop that repeats for the number
of rows minus 1. This yields a time complexity of
$T\left( n^{3} \right) = n \times \left( n^{2} + n^{2} \right) = n^{3} + n^{3} = n^{3} = O\left( n^{3} \right)$.

Finally, the entire matrix will be simplified so that all leading
numbers are equal to 1. This will scan the matrix row by row and divide
each row by the leading number. This will yield an efficiency of
O(n^2^), as a lop scanning each row will contain a loop multiplying the
column entries.

#### Back-Substitution

Once the matrix is reduced appropriately, so that all entries where *i*
\> *j* are equal to zero, back-substitution can take place. For this
section, it is necessary to work backwards, as stated by the name. An
array of the same size as the number of rows in the matrix will be
created and initialized to 0. The last index of the array, which
represents the final variable, will be equal to 1. Working backwards,
each entry in the array will equal the previous one times the negative
of its respective coefficient in the matrix. This accomplishes multiple
steps in one. This will yield an efficiency of O(n^3^), as a loop
passing backwards through each element in the array will contain a loop
passing through the columns of the matrix, which will contain a loop
adding every previous value of the array to the current one.

The lowest common multiple of all fractions of this array must then be
calculated and the array multiplied. An algorithm calculating the lowest
common multiple will not yield an efficiency higher than O(n), as it
tests all values in the array with an arbitrary value until it matches.

#### Output

Finally, once the solution is obtained, each value in the
*equationTerms* array class variable will be concatenated to the
respective value in the solutions array. This final array will be
converted back into a string using a single loop of efficiency O(n) and
displayed in the appropriate textfield.

The GUI will change to replace the first button with a "Try Again"
button, which, when clicked, will clear both textfields and revert back
to the input screen to allow the user to enter another equation to
balance.

### 2.4.3 UML Diagrams

#### Fractions Class

In the hopes of limiting rounding errors as much as possible, fractions must be used when manipulating the matrix. A
fraction class will also allow an easier method of turning the solution
set of the matrix into integers: by multiplying it by the least common
multiple (lcm) of the denominator of the solution set.

The *Fractions* class consists of three constructors: one will create a
fraction with initial value $\frac{0}{1}$, another will create a
fraction from an integer, and the last will create a fraction from a
string in the format "n/m". Then, there are two versions of methods for
every basic arithmetic operation. One version will return a fraction,
the other will modify the *Fractions* object itself. There are methods
that will obtain the numerator or the denominator, either as integers or
as fractions. Finally, there are miscellaneous methods. *toString()*
will return the fraction in the format "n/m". *toInt()* and *toDouble()*
will return the calculated integer or double value of the fraction,
respectively. *lcm()* will calculated the lowest common multiple of the
denominators of an array of fractions.

#### Matrix Class

The *Matrix* class allows the creation and
manipulation of matrices. In this case, as the matrix needs to be solved
by Gaussian elimination, all relevant methods can be found in the
*Matrix* class. To eliminate rounding errors and maintain precision, the
*Matrix* class has been designed to work with the *Fractions* class
instead of any primitive data types.

The main methods used, as detailed previously, will be the
*buildMatrix()* and *solveMatrix()* methods. For the sake of simplicity
and improved code structure, some of the code used in those methods have
been outsourced to methods such as *getNextNonZeroRow()* and
*backsubstitute()*.

The *solveMatrix()* method returns the balanced equation.

### 2.4.4 Features, Limitations and Constraints

##### Features

The Equation Balancer will allow a user to input an unbalanced equation
according to specifications outlined below. The equation can have any
number of terms and elements, as long as there is an equal number of
elements and terms or if there is one less element than terms. It will
allow the use of parentheses and subscripts (although they cannot be
inputted as such). The Equation Balancer allows the input of any element
or other name as long as the syntax is respected.

The Equation Balancer will balance and then display the equation. The
equation will be balanced accurately and the coefficients will be
simplified while staying integers, as expected by convention in
chemistry. The displayed equation will be formatted for the user's
convenience and ease of reading.

##### Limitations

The equation must be inputted according to certain specifications:

-   No coefficients must be present.

-   Subscripts must be entered as digits following the element they are
    subscript to (ex: H20 instead of H~2~O).

-   In order to mark the passage from the reactants to the products, an
    equal sign (=) must be used.

-   An element must always begin with a uppercase letter, followed by
    > either a lowercase letter if necessary or a digit if there is a
    > subscript.

-   Immutable groups must be replaced by other letters, as the equation
    > will not be able to be balanced otherwise (ex: C~6~H~5~C~2~H~5~ +
    > O~2~ = C~6~H~5~OH + CO~2~ + H~2~O cannot be balanced, C~6~H~5~
    > must be replaced by an arbitrary letter, so that the equation
    > resembles XC~2~H~5~ + O~2~ = XOH + CO~2~ + H~2~O).

##### Constraints

The input is case sensitive. As the elements are determined and
separated at uppercase letters, an element must begin with an uppercase
letter and continue with lowercase letters. An element beginning with a
lowercase letter will not be seen as an element but as a continuation of
another or will simply be ignored.

The equation balancer cannot balance ionic equations (ex:
$Fe^{3 +} + e^{-} = Fe$). It is not a supported feature.

The equations must be limited to those who have an equal number of terms
and elements or those who have one less element than terms. Any other
configuration will yield multiple answers through linear algebra, which
is not a situation this algorithm was designed to rectify.

The equations must not contain immutable groups, as that creates a
situation where there are less elements than terms. Replacing the groups
with other letters or elements will rectify the situation, as seen
above.

##  **2.6. Software**

### 2.6.1 IDE and Tools

#### Apache NetBeans 11.1

NetBeans will be used as the main IDE (Integrated Development
Environment); it will be used to program the four components of the
chemistry homework helper and to modify the various FXML files. This is
the program that was chosen because every member of the team is
comfortable with its environment and it also has an integration for
SceneBuilder.

#### SceneBuilder

SceneBuilder will be used to develop the GUI (Graphical User Interface).
This program was chosen because it is intuitive to use, it offers the
JavaFX components that will be needed, and it creates a FXML file when
one is necessary. SceneBuilder also offers an integration in the IDE
that will be used, NetBeans.

#### Ant

Ant will be used as the build tool for the chemistry homework helper. It
has an integration with NetBeans, the chosen IDE and it is the build
tool that the team members are the most comfortable using.

#### Git

Git will be used by creating a repository on GitHub. This tool can be
easily used, and it allows each team member to have access to the
project, that will be imported into the appropriate repository. By using
Git, everyone on the team will be able to pull the desired files, work
on them and push them back on the repository for everyone to see and
modify. GitHub also provides a Version Control, a feature that can be
used if something goes wrong when the project is being worked on and a
file needs to be reverted to a previous version. Moreover, many team
members can work at the same time on the project by using multiple
branches; they can be merged afterwards.

#### GitHub Desktop

GitHub Desktop will be used to facilitate the use of Git. Since the
repository of the chemistry homework helper will be hosted on GitHub,
its desktop app can be used to pull and push the project, create new
branches and merge them to the main branch, monitor the changes made to
the files and access previous version without using command lines as
much.

### 2.6.2. Targeted Platform

The chemistry homework helper will be supported on computers that are
running on either the Windows operating system or the macOS. This helper
is meant to be used by students at a CEGEP level in their chemistry
classes when applicable, this is why it was determined that the helper
will be a desktop app that will run on the majority of computers
(Windows and macOS). Targeting a mobile market would have forced the
development on either Android or Apple and would have restrained the
accessibility of the chemistry homework helper to the students.

### 2.6.3. Packages

#### JavaFX

JavaFX is the Java library that will be used to create the User
Interface of the chemistry homework helper. It will be used with
SceneBuilder and FXML files.

# 3. Main GUI

## 3.1. Main Page

The application's color palette will surround itself around the
following colors for a slight retro vide.

  ---------- ---------- ---------- ----------- ---------- ----------
  \#026670   \#9FEDD7   \#FEF9C7   \# FCE181   \#EDEAE5   \#F46021
  ---------- ---------- ---------- ----------- ---------- ----------

The main page will look something like the following mock-up. Users will
click on the box associated with each option to select what part of the
application they want. A different window will then pop up with the
preferred section.

## 3.2. Dark Mode

One of the features that will be added if time allows it will be a dark
mode variant of the UI that will turn the regular color palette into a
darker variant of itself. The purpose of this feature is to appeal to
the eye of people working in dark conditions, people who want to
conserve battery life on their computers, and people who prefer dark
mode in general.

# 4. Conclusion

QuickChemistry will offer useful assistance for students completing
homework by providing necessary information on the elements via an
interactive periodic table and helping with tedious equations such as
mass-to-mole conversion, limiting reagent calculation and equation
balancing. Each component of QuickChemistry will be easily accessible
and user friendly, for easy use by anyone. There might also be a dark
mode included, if time is found to make it work, so as to cater to the
visual taste of many.

We are confident that our project can be completed, and our objectives
met if everyone works hard and as long as a schedule of work is followed
in a respectable manner.

