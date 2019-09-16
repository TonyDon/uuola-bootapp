/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */

package com.uuola.webapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author tangxiaodong1
 * @date 2019年9月2日 上午9:25:47
 */
public class Child {
    public static void main(String[] args) {
        Set set = new HashSet<>();
        System.out.println(set instanceof Collection);
        int i = 1;
        System.out.println(i++ == 2);

    }

    private static List<Character> removeExistingChars(String text, String searchChars) {
        List<Character> textChars = new ArrayList<Character>();
        try {
            for (char c : text.toCharArray()) {
                textChars.add(c);
            }
            for (Character c : textChars) {
                if (searchChars.indexOf(c) >= 0) {
                    textChars.remove(c);
                }
            }
            return textChars;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException!");
        } catch (ClassCastException e) {
            System.out.println("ClassCastException!");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException!");
        } finally {
            System.out.println("Finally!");
        }
        throw new RuntimeException("error!");
    }

}
