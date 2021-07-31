## AcWing_LeetCode
### 基础算法
1. 快速排序：确定中间分界点，左右指针往外扩，三个while来快排，递归处理左和右
    - 引申：第k个数(等号边界同时取)
2. 归并排序：确定中间分界点，递归处理左和右，三个while来归并，左到mid右到r
    - 引申：逆序对的数量
3. 整数二分：左段取左，右段取右，左段+1
    - 解释：以上规则是if里第一个判断，左段右段指的是我们想要的那一半(满足条件那一半)，取左取右指的是边界变化；kth等号边界同时取
4. 浮点数二分：无边界问题，有精度问题
5. 加减乘除：人工计算，借位进位
6. 前缀：一维减区间，二维减区域，下标从1始
7. 差分：全0造差分，个体影响大
8. 双指针：循环数组双指针，小i小j需check，一方满足需++
    - 引申：最长连续不重复子序列、数组元素目标和、判断子序列
9. 位运算：取出k位二进制(n >> k & 1)，lowbit(x & -x)取2的对数
10. 离散化：排序去重加二分，区间由大化为小
### 数据结构
1. 动态单链表：全局边界初为null，先找儿子再找爹，边界增删特处理，游标0到k-1
2. 四则运算：右括乘除优先级，从右往左来计算
3. 单调栈：栈头元素需清理，栈头插入仍单调
4. 单调队列：队尾元素需清理，队尾插入仍单调
5. KMP：初始ne为-1， ij,-1需匹配，ij相等j++，ij不等i++
    - 思考1：ne[i]=j-1是因为ij相等时j会++, 所以ne[i]还是等于j的
    - 思考2：匹配时找到与i匹配的位置j的，直到j在起点，所以求ne时候ne[i]就是-1表示没有任何前缀相等
6. Trie：没有条件创造条件也要上，next节点为数组
7. 并查集：递归更新父节点，find三行最核心
    - 引申：连通块(额外维护size)，食物链(额外维护dist)
8. 小根堆：下沉三角取最小，上浮两者来比较
9. 索引优先队列：某位所存数据值 某值所在索引位，元素数组不可变
10. 哈希表：拉链法与开放寻址法
11. 字符串哈希：哈希需要PcQ，原理雷同前缀和
### 搜索图论
1. 树与图的存储：邻接表(稀疏图)，邻接矩阵(稠密图E ~ V^2)
2. 搜索

|算法|数据结构|空间(高度) |性质 |核心思想 |关键点|经典问题|
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|DFS|stack|O(h)|无最短性|不撞南墙不回头|终止条件+恢复现场|排列数字、n-皇后问题|
|BFS|queue|O(2^h)|最短路|眼观六路耳听八方|队列不空+扩展对头|走迷宫、八数码|

3. 最短路径

|算法|时间|应用场景|存储|关键点|
|:---:|:---:|:---:|:---:|:---:|
|朴素Dijkstra|O(V^2)|单源汇 + 正权边|邻接矩阵|寻找目标更新距离|
|堆优化Dijkstra|O(ElogV)|单源汇 + 正权边|邻接表|优先队列有冗余|
|Bellman-Ford|O(EV)|单源多汇 + 负权边(K)|边集合|使用备份更新距离|
|SPFA|O(E)|单源多汇 + 负权边|邻接表|不能存在负环TLE|
|Floyd|O(V^3)|多源汇|邻接矩阵|三重循环+dp|

4. 最小生成树

|算法|时间|应用场景|存储|关键点|
|:---:|:---:|:---:|:---:|:---:|
|朴素Prim|O(V^2)|稠密图|邻接矩阵|更新到连通块的距离|
|堆优化Prim|O(ElogV)|很少用|邻接表|优化雷同堆优化的最短路|
|Kruskal|O(ElogE)|稀疏图|边数组|边权排序与并查集|

5. 二分图

|算法|时间|应用场景|存储|关键点|
|:---:|:---:|:---:|:---:|:---:|
|染色法|O(E+V)|判断二分图|邻接表|dfs染色无矛盾|
|匈牙利算法|O(EV)|最大匹配|邻接表|舔狗的考虑与匹配|
### 数学知识
1. 试除优化法：可求质数与约束与欧拉函数
2. 分解质因数：除尽当前的质因子
3. 埃氏筛质数：当前的数筛其倍数
4. 线性筛质数：当前的数筛前质倍数，i % pj==0就break; 还能求欧拉函数
5. 唯一分解定理：质数幂的乘积，求约束个数与约束乘积
6. 欧几里得：a与b等于b与a模b
7. 扩展欧几里得：ax + by = gcd(a, b) = d; 求一组x, y的解
8. 同余方程：a * x ≡ b (mod m) 问题转为扩展欧几里得问题
9. 欧拉函数：互质数的个数 φ(N) =N * (1 - 1 / pi)，欧拉定理a ^ φ(N) ≡ 1 (mod N)
10. 费马求逆元：m范围内杀死除法，m-2次方即为其逆元(两数互质且m是质数)，欧拉定理只有两数互质
11. 快速幂：底数平方指数移位
12. 高斯解方程组：找到列的最大数，交换该行到顶部，首位需要化成1，扩大倍数消为0
13. 组合数：dp思想与打表思想
14. 卡塔兰数：一种操作是另一种操作的前提，两种操作的所有排列组合数
15. 容斥原理：并集等于奇加偶减
16. 博弈论：SG为0先手必败，异或为0先手必败，SG异或为0先手必败 (SG函数表示集合中最小的自然数)
### 动态规划
0. DP分析法
- 状态表示：f(i,j) = 集合(ij条件下的所有可能) + 属性(最大值，最小值，数量)
- 状态计算：集合当前i划分子集--热狗划分法，一般原则不重不漏
- Dp优化：条件1:f[i]只用到了f[i-1]，条件2: f[j]只在小于j的一侧，直接删掉用i层更新，倒序枚举约束使用i-1层更新
- 边界条件需要初始化，只考虑两次的状态转移，最新状态由上一次转移过来
1. 背包模型：01背包、完全背包、多重背包、分组背包
2. 线性DP：状态表示以第i(j)结尾，从i-1(j-1)转移过来
3. 区间DP：状态表示为一个区间i~j，枚举划分方式k，i~k; k+1~j; 枚举所有区间=区间长度 * 区间左端点
4. 数位DP：分类讨论，枚举到中位时，高位不动低位最大，大于中位取最大，等于取到中位值(0的从次高来枚举，再减低位最大值)
5. 计数DP：原理等同完全背包问题，需要注意边界问题
6. 状态压缩DP：数表示一组状态，二进制每位都是一个状态，然后使用二进制枚举
7. 树形DP：当前后选择互斥的时候，就有多种状态表示，例如i选了些i-1就不能选了，f[i][0], f[i][1]
8. 记忆化搜索：DP的一种实现方式，适合状态计算一次就可以确定的情况，避免重复计算
9. 字符串的动态规划i去0-str.length()，数组开到str.length() + 1; 字符串状态ij对应到charAt中为i-1,j-1
### 贪心问题
1. 排序试一下
2. 证明走一波
### 思考心得
1. 如果算法无法继续优化，仍然遇见TLE，则需要在io上进行优化，BufferedReader + BufferedWriter + StringBuilder
2. 对象有多少个属性(动态)，就需要多少个数组(静态)
3. 初始为-1，新增时idx++，则idx指向最后一个元素，初始值为0新增时idx++，则idx指向待插入的位置
4. 区间长度与索引的相爱相杀±1
5. 双指针/区间端点：结束等号，继续不带
6. 判断没有小数：expr % 1 == 0
7. DFS剪枝就是如果满足某种条件才进入递归，分为最优性剪枝和可行性剪枝
8. DFS中子节点信息或者未来的信息在当前属于已知信息，这就是回溯的力量
9. 使用队列对Dijkstra和Bellman-Ford算法进行优化，就得到了堆优化版Dijkstra和SPFA算法
10. 使用Bellman-Ford与SPFA利用抽屉原理求负环
11. 四种单源最短路径终止条件都一样，即轮到我去松弛别人的时候那到我的路径一定是最短的
12. 如果整数取反操作，直接用两个数之和减去该值，0取1且1取0则1-x，1取2且2取1则3-x
13. 数组其实是一种特殊的Map，即key为int类型的Map
14. 一维转二维 x = k / n，y = k % n；二维转一维 k = x * n + y (n表示行数)
15. 使用二维数组使用向量表示方向dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1}
16. 距离和权值初始化为Integer.MAX_VALUE / 2 (一个很大的数)主要是为了防止相加时溢出
17. 不同进制的计算，10 * t + c，2 * t + c更一般的情况为p * t + c
18. 一个数取2的对数，能够知道占据了多少位，或者直接用位运算>>1
19. a % m = a - (a / m) * m = b ; a = k * m + b
20. 二维数组某列列不动，某行行不动
21. mod = 1e9 + 7，运算时，相加不超过int最大值，相乘不超过long最大值
22. 二进制枚举：i < 1 << n; j < n; i >> j & 1 -- 种群1<<n;个体i;基因j;
23. 二进制优化：k <= n; n -= k; k *= 2;
24. 凡是一步一步去操作的字符串问题，先考虑双指针再考虑动态规划，一般来说动态规划多一点
25. 两只有一个为空判断：或空，与空
26. 二叉搜索树的中序遍历通过其他遍历方式排序即可得到，入队次序即是层序遍历的结果
27. 前序遍历--根左右，中序遍历--左根右，后序遍历--左右根; 树的递归终止条件即节点为空，或者节点为叶节点
28. 新建链表题目需要创建head = new Node(0) 与 cur = head 搭配使用最后返回head.next
29. 常用下标i-j-k; n-m; l-r; u-v; a-b; x;
30. 常用变量名res; ans; tmp; tgt; cnt; val; maxv; minv; bits; len;
31. 下取整 n / i， 上取整 (n + i - 1) / i
32. 当双指针相遇的时候，i-j、l-r都可以返回，不过规定下统一返回右边的j，或者r
### 文字笔记
<img src="https://github.com/CyS2020/AcWing_LeetCode/blob/main/src/main/resources/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20210411110707.jpg" alt="第二页" align=center /><br/>
<img src="https://github.com/CyS2020/AcWing_LeetCode/blob/main/src/main/resources/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20210411110656.jpg" alt="第一页" align=center /><br/>
