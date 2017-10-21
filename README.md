# 算法工程师面经推荐系统

## 总体需求

算法工程师面经推荐系统
 
## 功能需求

### 数据抓取

* 数据源：牛客网，百度"算法工程师面经"关键字
* 数据存储位置：Mysql数据库(sql+mybatis )

### 数据分析

* 关键词提取
* 词频统计
* 面经鉴别和打分
* 面经个性化推荐

## 复用需求

* 预测知乎上一篇文章有多少赞





# 根据抓取结果产生人工写的的初版面经

### 前言

算法工程师是一个神秘的职位，与时下最热的人工智能，机器学习等名词息息相关，其超高的薪资和诱人的职业前景吸引了越来越多的人投身其中（[比如这个非985，211本科非计算机专业毕业零基础的小机务，也要成为算法工程师](https://zhuanlan.zhihu.com/p/27515227) ）。
那么这个岗位到底是干啥的，面试到底问什么呢？本人于2016年经历了校招洗礼(中科院计算所毕业)，并拿到一些算法工程师offer。如今已经入职工作一段时间，对这个岗位有了一定了解，在这里把一些经验分享给大家。

注意事项
1. **本文致力于做最好的算法工程师面经～会长期更新，并会努力覆盖我和我同学被问过以及我能从互联网上能查到的所有问题～**
2. 本文更**侧重**算法工程师面试中具有特色的**机器学习等部分**，对程序语言，leetcode编程题等部分也会有所提及，但不会是本文重点。
3. 本文会在[github](https://github.com/rrdssfgcs)更新，欢迎大家推送自己遇到的问题或进行纠错～

### 这个岗位是什么

一些不了解这个岗位的同学可能从字面认为算法工程师是设计冒泡排序，二分查找等算法的程序员，但**实际工作中算法工程师大多从事的是与图像识别，推荐搜索等机器学习和人工智能相关的算法开发和优化工作**。

就校招形势来看，这个岗位的发展前景和薪资水平与其他职位相比还是具有一定优势的，special offer中很多都发给了算法岗。[20 万、50 万、100 万年薪的算法工程师在能力素质模型上有哪些差距？](https://www.zhihu.com/question/59461289) 这个问题很火，感觉无意中也成了算法工程师能挣很多钱的推广软文。在移动互联网时代过去之后，各个巨头乃至整个行业的关注点很多都集中在了机器学习和人工智能这一块，算法工程师的关注度得到了巨大提升。总体来说我还是非常喜欢并看好这个岗位的。

### 人人都是算法工程师？

2016年投简历初期，自己也在研发工程师和算法工程师中间犹豫了很久。开始的一大疑问是，算法岗是不是应该录的博士比较多？自己一个小硕士是不是没有什么优势。但最终做决定还是对这个岗位进行尝试。**从三月中旬开始进行复习到八月初收到第一个offer(小米探索实验室)，中间经历了五个月的总时间，但这中间很多时间在做实验室的项目，还有很多都是绕弯路。** 我觉得成为一个算法工程师似乎也没有想象中那么困难。我也认为只要方法得当，人人都可以成为算法工程师，所以就有了这个 **[人人都是算法工程师的专栏](https://zhuanlan.zhihu.com/p/27515227)**，这个专栏里将分享我把一个非计算机专业零基础的小机务一步步培养成一个算法工程师的过程，希望能帮到大家。

### 简历

很多同学的简历可能存在华而不实的现象，虽然模板花哨但难以吸引HR的注意力。当时进行海投的时候，我们所使用的简历模版基本上是“千篇一律”的，可见这个模版还是被广泛认可的，在这里可以下载~

对于简历的书写原则，推荐大家按照以下原则来展示

* 写到简历上的东西一定要熟练掌握
* 个人技能，项目经历要尽可能跟求职岗位相关
* 尽可能用数据说话，如成绩排名5%，效果提升20%
* 尽可能不要出现精通xxx的词语，写熟练即可
* 对于互联网公司，是否单身，是否党员等信息是没有必要写的
* 联系方式可以留多个
* 海投时可以使用git等工具对简历进行版本控制

### 笔/面试流程

算法工程师的笔试一般与研发工程师的笔试过程大同小异，但会更多的涉及类似概率统计和机器学习类的题目。面试的流程一般会先进行**多次技术面**(一般是三次，第一面是平级同事面试，然后是小组长，最后是总监)和**一次HR面**。技术面的面试过程基本类似，一般包含的模块为
1. 自我介绍

这个部分较为简单但也非常重要，我的经验是你的自我介绍要给面试官一种信心，让他认为你可以胜任这份工作。

> 举个栗子
> 
> 您好，我是xxx，毕业于xxx学校(来自xxx公司)，以前的做的主要是xxx。 <先讲自我简介>
> 
> 我觉得针对这个岗位，我的优势有：我学过xxx课程，掌握xxx技能，有xxx的项目经验。 <直奔主题>
> 
> 我觉得xxx项目是我认为自己做的比较好的项目，您有兴趣我可以给您讲一下。 <把面试官引向自己熟悉的领域, 防止他问奇奇怪怪的问题>

2. 手写算法题

这个部分主要是leetcode类的算法题，刷题越熟练，拿到spcial offer的可能性越大。但现在的leetcode题数实在太多，面试中面试的高频问题我已经在下文进行整理，方便大家查看。

3. 项目介绍

这部分推荐用 **STAR法-情境(situation)、任务(task)、行动(action)、结果(result)** 介绍，且最好可以用一些**量化指标**展示自己的工作成果。如果没有做过项目，可以做个天池／kaggle，基本上能把一个项目讲的透彻就可以了。

4. 即兴提问环节

这个部分一般会结合你的项目，问一些项机器学习(每次必问)，语言基础(一般会问)，计算机基础(偶尔会问)，系统设计(偶尔会问)，智力题(其实很少问)的问题。这部分的持续时间往往是最长的。

5. 提问环节

这个过程一般在最后，面试官会让你对感兴趣的部分对他进行提问。


最后的HR面一般会对价值观，工资要求，职业发展等问题提问，这一面的通过率一般还是较高的。

### 面试问题列表

结合上文的的面试流程，总结起来，所有的算法工程师主要需要掌握以下几个方面的核心技能。
* 机器学习相关知识 
    * 数学基础(概率统计最为重要，一些高等数学，线性代数知识是做模型推导的基础)。
    * 常见的模型(如LR,SVM等)的推导和优缺点比较，如果是深度学习岗会问相关的问题。
    * 结合实际项目的常见问题(特征选择，过拟合等)。
* 数据结构和算法相关知识 
    * 剑指offer和leetcode上的常见题，这部分重要性较高。
* 编程语言
    * 一般会挑你最熟悉的语言(如c/c++,python等)进行提问，这方面的要求其实比研发工程师低。
* 计算机基础
    * 操作系统，数据库，计算机网络基础知识。

下边将分章节对各个模块的常见问题做一下总结。

### 机器学习相关问题

#### 数学基础

1. 条件概率题(笔试经常考)
2. 大数定理和中心极限定理是什么？
3. [正态分布？](http://www.flickering.cn/%E6%95%B0%E5%AD%A6%E4%B9%8B%E7%BE%8E/2014/06/%E7%81%AB%E5%85%89%E6%91%87%E6%9B%B3%E6%AD%A3%E6%80%81%E5%88%86%E5%B8%83%E7%9A%84%E5%89%8D%E4%B8%96%E4%BB%8A%E7%94%9F%E4%B8%8A/)

#### 机器学习模型(所有岗位必备)

> 机器学习模型主要从以下几个方面来掌握
> 
> a.产生背景，适用场合（数据规模，特征维度，是否有 Online 算法，离散/连续特征处理等角度）；
> 
> b.原理推导（最大间隔，软间隔，对偶）；
> 
> c.求解方法（随机梯度下降、拟牛顿法等优化算法）；
> 
> d.优缺点，相关改进；
> 
> e.和其他基本方法的对比；

* K-means
    * 伪代码 
* KNN
    * 伪代码
    * k近邻算法k的选择对结果的影响？
    * 偏倚方差分解，以k近邻为例，分析k的变化对偏倚方差的影响？
* 朴素贝叶斯
* 感知机
    * 推导
* Logistics回归
    * 推导
* SVM
    * 推导
    * SVM有哪些核函数？如何选择？
    * KKT条件
* 决策树
    * 划分标准
* 随机森林RF
    * 伪代码
    * 随机森林与图像分类的结合
* GBDT
    * 推导/伪代码
* boosting
* EM算法
* 隐马尔可夫模型
    * Viterbi算法伪代码
* 神经网络/深度模型

* 常见问题
    *  感知机 VS Logistics回归 VS SVM对比
    *  决策树 VS RF VS GBDT 对比
    *  L1正则 和 L2正则的区别

#### 数据类算法工程师

* 如何做数据预处理？
* 如何做特征选择？
* 如何选择模型/调参数？
* 常见的评价指标？
* 如何做模型融合？

#### 图像类算法工程师相关问题

To be done...

### 数据结构和算法相关问题

#### 我每次面试出门前手写一遍用于热身的题

二分查找/反转链表/快排(数组中前K大个数)/堆排/二叉树遍历(非递归)/Best Time to Buy and Sell Stock/Permutations/连续子数组的最大和

#### 剑指offer划重点(师兄划的，加粗先看)

##### 链表

* **03_二维数组中的查找**
* 06_重建二叉树
* 07_用两个栈实现队列
* **08_旋转数组的最小数字**
* 10_二进制中1的个数
* 13_在O1时间删除链表节点
* **14_调整数组顺序使奇数位于偶数前面**
* 15_链表中倒数第k个结点
* **16_反转链表**
* 17_合并两个排序的链表
* 19_二叉树的镜像
* 20_顺时针打印矩阵
* 21_包含min函数的栈
* 23_从上往下打印二叉树
* 25_二叉树中和为某一值的路径
* 26_复杂链表的复制
* 27_二叉搜索树与双向链表
* **28_字符串的排列**
* 29_数组中出现次数超过一半的数字
* 30_最小的K个数
* 31_连续子数组的最大和
* **35_第一个只出现一次的字符**
* **37_两个链表的第一个公共结点**
* 38_数字在排序数组中出现的次数
* **40_数组中只出现一次的数字**
* 41_和为S的两个数字
* 42_翻转单词顺序列
* 49_把字符串转换成整数
* 56_链表中环的入口结点
* 60_把二叉树打印成多行
* 61_按之字形顺序打印二叉树
* 62_序列化二叉树
* 蓄水池算法
* rand5产生rand7

### 编程语言相关问题
#### C++
1. 虚函数相关问题
2. 手写实现Vector
3. const/static关键字
4. malloc/free和new/delete
5. 重载VS重写VS隐藏
6. 容器类
7. 友元

### 计算机基础相关问题

#### 操作系统

1. 进程和线程有什么区别？

#### 数据库

1. 索引相关问题
2. 常用SQL语句
3. 三范式规范化

#### 计算机网络

1. TCP三次握手，四次挥手
2. OSI七层网络模型
2. TCP/UDP协议基础

#### 设计模式

1. 单例设计模式
2. DAO设计模式
