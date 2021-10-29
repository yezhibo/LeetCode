package com.yezhibo.leetcode.function;

import org.junit.Test;

/**
 * 2043.简易的银行系统
 * https://leetcode-cn.com/problems/simple-bank-system/
 */
public class Bank {
    long[] balance;
    int size;
    public Bank(long[] balance) {
        this.size = balance.length;
        this.balance = new long[size+1];
        System.arraycopy(balance, 0, this.balance, 1, size);
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!isValidAccount(account1) || !isValidAccount(account2)) {
            return false;
        }
        if (!isValidMoney(balance[account1], money)) {
            return false;
        }
        balance[account1] = balance[account1] - money;
        balance[account2] = balance[account2] + money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!isValidAccount(account)) {
            return false;
        }
        balance[account] = balance[account] + money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!isValidAccount(account) || !isValidMoney(balance[account], money)) {
            return false;
        }
        balance[account] = balance[account] - money;
        return true;
    }

    private boolean isValidAccount(int account) {
        return account > 0 && account <= size;
    }

    private boolean isValidMoney(long remainMoney, long money) {
        return money <= remainMoney;
    }


    public static void main(String[] args) {
        Bank bank = new Bank(new long[]{10, 100, 20, 50, 30});
        System.out.println(bank.withdraw(3,10));
        System.out.println(bank.transfer(5,1,20));
        System.out.println(bank.deposit(5,20));
        System.out.println(bank.transfer(3,4,15));
        System.out.println(bank.withdraw(10,50));
    }
}
