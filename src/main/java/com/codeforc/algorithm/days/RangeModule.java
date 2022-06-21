package com.codeforc.algorithm.days;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022-06-20
 * Range模块是跟踪数字范围的模块。设计一个数据结构来跟踪表示为 半开区间 的范围并查询它们。
 * 半开区间[left, right)表示所有left <= x < right的实数 x 。
 * 实现 RangeModule 类:
 * RangeModule()初始化数据结构的对象。
 * void addRange(int left, int right) 添加 半开区间[left, right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间 [left, right) 中尚未跟踪的任何数字到该区间中。
 * boolean queryRange(int left, int right)只有在当前正在跟踪区间[left, right)中的每一个实数时，才返回 true，否则返回 false 。
 * void removeRange(int left, int right)停止跟踪 半开区间[left, right)中当前正在跟踪的每个实数。
 */
public class RangeModule {

    private List<Range> ranges = new ArrayList<>();

    class Range {

        private Integer leftRange;

        private Integer rightRange;

        public Integer getLeftRange() {
            return leftRange;
        }

        public void setLeftRange(Integer leftRange) {
            this.leftRange = leftRange;
        }

        public Integer getRightRange() {
            return rightRange;
        }

        public void setRightRange(Integer rightRange) {
            this.rightRange = rightRange;
        }
    }

    public RangeModule() {

    }

    public void addRange(int left, int right) {
        if(ranges.isEmpty()) {
            Range range = new Range();
            range.setLeftRange(left);
            range.setRightRange(right);
            ranges.add(range);
            return;
        }
        for (Range range : ranges) {

        }
    }

    public boolean queryRange(int left, int right) {
        return false;
    }

    public void removeRange(int left, int right) {

    }
}
