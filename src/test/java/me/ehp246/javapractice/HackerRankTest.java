package me.ehp246.javapractice;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import me.ehp246.javapractice.hackerrank.HackerRank;

class HackerRankTest {

    @Test
    void cookie_01() {
	Assertions.assertEquals(2, HackerRank.cookies(7, List.of(1, 2, 3, 9, 10, 12)));
	Assertions.assertEquals(4, HackerRank.cookies(9, List.of(2, 7, 3, 6, 4, 6)));
    }

}
