package com.codeforc.algorithm.days;

/**
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * 你可以做一些数量的移动 numMoves :
 * 每次你可以选择向左或向右移动。
 * 第 i次移动（从 i == 1开始，到i == numMoves ），在选择的方向上走 i步。
 * 给定整数target ，返回 到达目标所需的 最小移动次数(即最小 numMoves )。
 * 示例 1:
 * 输入: target = 2
 * 输出: 3
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 -1 。
 * 第三次移动，从 -1 到 2 。
 * 示例 2:
 * 输入: target = 3
 * 输出: 2
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 3 。
 */
public class EndNumber {

    /**
     * 提示一：数轴上的任意点都以起点（00 点）对称，只需要考虑对称点的任意一边
     * 由于题目没有限制我们「不能到达哪些点」以及「出发的起始方向」，因此以起点为中心的左右两边对称。
     * 即：左边所能到达任意一个点，都能通过调整所达路径的方向来将终点调整到右边。
     * 同时由于起点是一个特殊的位置 00 点，因此相应的「正数点」和「负数点」对称，我们仅需考虑一边（例如正数域）即可。
     * 提示二：先往靠近 target 的方向移动，到达或越过 target 的时候则停止
     * 只考虑 target 为正的情况，我们假定起始先往靠近 target 的方向移动（即所有步数均为正值），根据是「到达」还是「越过」target 位置分情况讨论：
     * 若能直接到达 target，此时消耗的必然是最小步数，可直接返回；
     * 若越过了 target，假设此时消耗的步数为 kk，所走的距离为 dist = \frac{k \times (k + 1)}{2} > targetdist=
     * 2
     * k×(k+1)
     *  >target，我们可以考虑是否需要增加额外步数来到达 target。
     * 提示三：越过 target 时，如何不引入额外步数
     * 若不引入额外步数，意味着我们需要将此前某些移动的方向进行翻转，使得调整后的 dist = targetdist=target。
     * 我们假设需要调整的步数总和为 tot，则有 dist - 2 \times tot = targetdist−2×tot=target，变形可得 tot = \frac{dist - target}{2}tot=
     * 2
     * dist−target
     * 若想满足上述性质，需要确保能找到这样的 tot，即 tot 合法，
     * 不难推导出当 dist 和 target 差值为「偶数」时（两者奇偶性相同），我们可以找到这样的 tot，从而实现不引入额外步数来到达 target 位置。
     * 由于我们的 distdist 是由数列 [1,2,3,...,k][1,2,3,...,k] 累加而来，因此必然能够在该数列 [1,2,3...k][1,2,3...k] 中通过「不重复选择某些数」来凑成任意一个小于等于 distdist 的数。
     * 提示四：越过 target 时，如何尽量减少引入额外步数
     * 当 dist 和 target 差值不为「偶数」时，我们只能通过引入额外步数（继续往右走）来使得，两者差值为偶数。
     * 可以证明，最多引入步数不超过 44 步，可使用得两者奇偶性相同，即不超过 44 步可以覆盖到「奇数」和「偶数」两种情况。
     * 根据 kk 与 44 的余数关系分情况讨论：
     * 余数为 00，即 k = 4Xk=4X，由于 dist = \frac{k(k+1)}{2} = \frac{4X(4X+1)}{2} = 2X(4X+1)dist=
     * 2
     * k(k+1)
     *  =
     * 2
     * 4X(4X+1)
     *  =2X(4X+1)，其中一数为偶数，distdist 为偶数；
     * 余数为 11，即 k = 4X + 1k=4X+1，由于 dist = \frac{k(k+1)}{2} = \frac{(4X+1)(4X+2)}{2} = (4X+1)(2X+1)dist=
     * 2
     * k(k+1)
     *  =
     * 2
     * (4X+1)(4X+2)
     *  =(4X+1)(2X+1)，两个奇数相乘为奇数，distdist 为奇数；
     * 余数为 22，即 k = 4X + 2k=4X+2，dist = \frac{k(k+1)}{2} = \frac{(4X+2)(4X+3)}{2} = (2X+1)(4X+3)dist=
     * 2
     * k(k+1)
     *  =
     * 2
     * (4X+2)(4X+3)
     *  =(2X+1)(4X+3)，两个奇数相乘为奇数，distdist 为奇数；
     * 余数为 33，即 k = 4X + 3k=4X+3，dist = \frac{k(k+1)}{2} = \frac{(4X+3)(4X+4)}{2} = (4X+3)(2X+2)dist=
     * 2
     * k(k+1)
     *  =
     * 2
     * (4X+3)(4X+4)
     *  =(4X+3)(2X+2)，其中一数为偶数，distdist 为偶数。
     * 因此在越过 target 后，最多引入不超过 44 步可使得 dist 和 target 奇偶性相同。
     * 提示五：如何不通过「遍历」或「二分」的方式找到一个合适的 k 值，再通过不超过 44 步的调整找到答案
     * 我们期望找到一个合适的 k 值，使得 dist = \frac{k \times (k + 1)}{2} < targetdist=
     * 2
     * k×(k+1)
     *  <target，随后通过增加 k 值来找到答案。
     * 利用求和公式 dist = \frac{k \times (k + 1)}{2}dist=
     * 2
     * k×(k+1)
     *  ，我们可以设定 k = \left \lfloor \sqrt{2 \times target}) \right \rfloork=⌊
     * 2×target
     *  )⌋ 为起始值，随后逐步增大 k 值，直到满足「dist 和 target 奇偶性相同」。
     */
    public int reachNumber(int target) {
        if (target < 0) target = -target;
        int k = (int) Math.sqrt(2 * target), dist = k * (k + 1) / 2;
        while (dist < target || (dist - target) % 2 == 1) {
            k++;
            dist = k * (k + 1) / 2;
        }
        return k;
    }

    public static void main(String[] args) {
        EndNumber endNumber = new EndNumber();
        int i = endNumber.reachNumber(4);
        System.out.println(i);
    }
}