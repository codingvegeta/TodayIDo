package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.BoardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDaoImplTest {
    @Autowired
    BoardDao boardDao;

    @Test
    public void select() throws Exception {
        assertTrue(boardDao != null);
        BoardDto boardDto = boardDao.select(1);
        System.out.println(boardDto);
        assertTrue(boardDto.getBno().equals(1));

    }

    @Test
    public void count() {
    }

    @Test
    public void deleteAll() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void selectAll() {
    }

    @Test
    public void selectFromBoard() {
    }

    @Test
    public void selectPage() {
    }

    @Test
    public void update() {
    }

    @Test
    public void updateCommentCnt() {
    }

    @Test
    public void increaseViewCnt() {
    }
}