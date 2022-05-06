Samantha Hua
APCS pd7
HW93 -- exploring tree properties, extracting actionable intel from traversals
2022-05-05r
time spent: .8 hrs


DISCO
------------------------------------------------
* Only the preorder tree traversal processes the nodes at the top of the tree before
the nodes on the bottom of the tree. In order and post order tree traversal process
the nodes at the bottom of the tree before the nodes at the top of the tree.
================================================


QCC
------------------------------------------------
* What are some real life applications of each of these tree traversal methods?
* In what situations are certain traversal strategies better than others?
================================================


SELF-ASSESSMENT PROMPTS
------------------------------------------------
In which direction does a tree grow?
A tree grows down

Provide as many alternate definitions as you can for "tree," using graph terminology ("closed/open tours", "paths", "cycles", etc). Maximize clarity, succinctness.
A tree is a graph where the path is closed and there are no cycles. There may be
many paths through the tree, but any one path ends at a certain point.

Why is a balanced tree allowed a difference of 1 in height between right and left subtrees?
I'm not sure but it could be something about uniformity in the tree which allows
for consistency in the way it is traversed or treated.

Alternate (equivalent, but more succinct?) definitions of "balanced" tree?
A tree whose

Is a perfect tree complete?
Yes a perfect tree is complete because a perfect tree has every level full and the
requirements for a complete tree is to have every level filled with exceptions for the
bottom level. Every perfect tree is complete but not all complete trees are perfect.

Is a complete tree balanced?
A complete tree is balanced because in a complete tree, every level is filled
except maybe the bottom. That means that there is at most a 1 level difference within the tree.

Is the Man Who Is Tall Happy?
The Piazza post on this phenomenon was confused but from what I can understand, the
core of the question is the placement of the "is"'s in "is the man who is tall happy?" This
stands in contrast to the statement "the man who is tall is happy." both statements use
two is's but in the question, the "is" is at the front of the question. this makes it
easier to place the is at a level that is closer to the root and left most justified so it
can be reached easily.

What must be true of perfect trees but not others?
All of their levels must be full meaning the tree's most bottom layer has as many
children as can possibly fit in the layer.
================================================


C'EST POSSIBLE?
------------------------------------------------
I do not believe the combination is possible.
pre order: processes the given node, left branch, then right branch. processes from the top node to the bottom node
in order: processes the left branch, given node, then right branch. processes from the bottom node to the top node

pre order: EGDKINLOW
in order: EKDNIOLWG

with these given statements, we know that E is at the root of the tree because it
is the first node listed in the pre order list which we know to process the top most
node first. E is also the first node listed in the in order list meaning there is
no left branch off E because in order tree traversal processes the left branch before
the given node.

we see that G is the second node processed after E in pre order meaning it is the top node
of the right branch off E.

we can then look at the end of the listed process order. for pre order, the last node
that was processed was W. This means that W is the right most node of the bottom most level.
for in order, G is the last node processed which means that there are no right brances off G.
We already know G to be the only node off of E (the root) so G will be the
top root after E and we also know that in order processes left branch and then its
own node. This means that everything processed before G and after E is in the left
branch of the G.

The element right before the G is W and given the process method of in order, W
must be in the level right under G and it is on the left branch of G. This however
contradicts the conclusions about W that were made earlier given the pre order process
order.

These contradictions led me to think that the tree is not possible.
================================================
