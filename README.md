# Task implement Depth First Search and Depth First Traversal 
- Depth First Search vs Depth First Traversal:
- - 1) DFT is a a traversal which usually applied on the disconnected Graph. While DFS is an algorithm which is applied on the connected graph;
- - 2) DFS did not gurantee that it will visit each and every node while DFT do;
- - 3) DFT uses DFS;
- - 4) DFS visit as much as he can be fore hitting the goal vertex started by vetrex that we choose.Not gurantee that he visit all vertexes;
- - 5) DFT visit all vertexs which can be available from start vertex by edges;

## Graph class 
```
addVertex - add vertex 
addedges - makes connections between two vertexes

removeEdge - remove connections between two vertexes
removeVertex - remove vertex

getAdjVertices - returns array(edges) of vertex that we passes as parameter

printGraph - builds string as 2[4, 5]4[2, 5]5[4, 2]
```
## DepthFirstSearch
```
depthFirstTraversal - return set(all edges) which we able to pass by vertex we pass as parameter

depthFirstSearch - return boolean if vertex are avalible from vertex we pass as parameter
```

## hOw tO rUn tEsT
Download junit-4.10 link: https://sourceforge.net/projects/junit/
```
PASS_TO_junit-4.10.jar example C:\Users\user\Desktop\JUNIT\junit-4.10.jar
```
```
$ java -cp PASS_TO_junit-4.10.jar org.junit.runner.JUnitCore GraphTest.java
```
<details>
<summary>༼ つ ಥ_ಥ ༽つ</summary>
<p>
(https://youtu.be/fEiNQuzyfa4)
  
```java
БОШЕНТУНМАЙ
```
</p>
</details> 
