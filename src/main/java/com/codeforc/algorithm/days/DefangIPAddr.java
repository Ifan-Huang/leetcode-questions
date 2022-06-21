package com.codeforc.algorithm.days;

/**
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * 示例 1：
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 */
public class DefangIPAddr {

    public String defangIPaddr(String address) {
        if(null == address || "".equals(address)) return "";
        String point = "\\.";
        String pointResult = "[\\.]";
        return address.replaceAll(point, pointResult);
    }

    public static void main(String[] args) {
        DefangIPAddr defangIPAddr = new DefangIPAddr();
        System.out.println(defangIPAddr.defangIPaddr("1.1.1.1"));
    }
}
