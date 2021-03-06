1. 算法（algorithm）
    1. 算法复杂度计算
        1. 用常数1取代运行时间中的所有加法常数
        2. 在修改后的运行次数函数中，只保留最高阶
        3. 如果最高阶存在且不是1，则去除与这个项相乘的常数
    2. 常见的时间复杂度
        1. O(1)<O(㏒2n)<O(n)<O(n²)<O(2^n)
2. 线性表（List）
    1. 定义：零个或多个数据元素的有限序列。
    2. 顺序存储结构 
        1. 优点 快速读
        2. 缺点 插入删除操作反锁 O(n) 空间碎片多
    3. 链式存储结构
        1. 数据域 + 指针域
        2. 头指针 第一个结点的指针 必要元素
        3. 头结点 方便操作 非必要元素
    4. 静态链表
        1. 用数组描述的链表
        2. 插入删除操作只需要修改游标，不需要移动元素
        3. 没有解决存储分配表长难以确定的问题
        4. 失去了顺序存储结构随机存储的特性（这里的随机是和顺序相反的意思）
    5. 循环链表
    6. 双向链表
3. 栈（stack）
    1. 定义：限定在表尾进行插入和删除操作的线性表
    2. 顺序存储结构 链式存储结构
    3. 解决最近相关性
4. 队列（queue）
    1. 定义：只允许在一端进行插入操作，而在另一端进行删除操作的线性表
    2. 顺序队列 循环队列
    3. 链队列
5.   串（string）
    1. 定义：是由零个或多个字符组成的有限序列，又名叫字符串
    2. 朴素匹配 O(n + m)
    3. KMP算法 计算PMT（Partial Match Table/部分匹配表）
    4. KMP算法优化