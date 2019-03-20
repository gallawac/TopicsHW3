# TopicsHW3

Colin Gallaway and Andrew Chough

How to run  the Puzzle Verifier: <br/>
Download all files <br/>
Open two Command Lines/Terminals and change directories to the relevant folder <br/>
Compile Verifier and Solver ("javac Verifier.java" and "javac Solver.java") <br/>
Run Verifier in first terminal ("java Verifer") <br/>
Run Solver in second terminal ("java Solver") <br/>

The versions of Block and BlockHeader have been updated in this version to more accurately follow standard bitcoin structures. When a Block is instantiated, it tries to find a BlockHeader that hashes to a value that is less than the given target value (a parameter of Block).

New in Homework 3 is the Verifier, Solver, and Message classes. Verifier acts as a server, waits for a connection from an appropriate client, and receives a messsage (a Message object) from client. It will open that message, get the hash of a header, and check whether it is below the target value. Solver will create a new Block and send a Message of the components of the Block Header and its hash to the Verifier.

Target value is hardcoded into Verifier and Solver: "1ABBC33775DF223A1ABBC33775DF223A1ABBC33775DF223A1ABBC33775DF223A"
