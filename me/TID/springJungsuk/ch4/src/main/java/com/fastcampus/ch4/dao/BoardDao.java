package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.BoardDto;
import com.fastcampus.ch4.domain.SearchCondition;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BoardDao {
    BoardDto select(Integer bno) throws Exception;

    int count() throws Exception;

    int deleteAll();

    int delete(Integer bno, String writer) throws Exception;

    int insert(BoardDto dto) throws Exception;

    List<BoardDto> selectAll() throws Exception;


    List<BoardDto> selectPage(Map map) throws Exception;

    int update(BoardDto dto) throws Exception;

    int increaseViewCnt(Integer bno) throws Exception;

    List<BoardDto> searchSelectPage(SearchCondition sc) throws Exception;

    int searchResultCnt(SearchCondition sc) throws Exception;

    int updateCommentCnt(Integer bno, int cnt);

//    BoardDto selectFromBoard() throws Exception;

//    int updateCommentCnt(Map<Integer, Integer> map) throws Exception;
//
//    int increaseViewCnt(Integer bno) throws Exception;
}
