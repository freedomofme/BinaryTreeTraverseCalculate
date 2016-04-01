# BinaryTreeTraverseCalculate



#### 起因
考虑到在不少场景下，会遇到根据中序遍历加上一个先序遍历或者后序遍历来获得整棵二叉树。所以选做一个自动化的工具。

### 使用
本APP的作用是输入其中两个结果遍历顺序，此时这棵二叉树就已经固定了，输出另一个遍历顺序。
例如

* 先序：abdefgc
* 中序：debgfac

APP将输出后序的结果：[e, d, g, f, b, c, a]

如图所示：

根据先序、中序计算后续：
![screenshot1](https://github.com/freedomofme/BinaryTreeTraverseCalculate/blob/master/screenshot/S60401-194019.jpg?raw=true)

根据后序、中序计算先续：
![screenshot2](https://github.com/freedomofme/BinaryTreeTraverseCalculate/blob/master/screenshot/S60401-194036.jpg?raw=true)

### 实现介绍

[参见博客](http://freedomofme.github.io/post/%E5%A6%82%E4%BD%95%E6%A0%B9%E6%8D%AE%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E4%B8%AD%E5%BA%8F%E5%92%8C%E5%89%8D%E5%BA%8F%E5%90%8E%E5%BA%8F%E6%8E%A8%E5%AF%BC%E5%87%BA%E6%95%B4%E6%A3%B5%E4%BA%8C%E5%8F%89%E6%A0%91/)






