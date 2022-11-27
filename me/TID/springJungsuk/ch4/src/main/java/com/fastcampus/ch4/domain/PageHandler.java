package com.fastcampus.ch4.domain;

public class PageHandler {
    int totalCnt; // 총 게시물 갯수
    int pageSize; // 한 페이지의 크기
    int naviSize = 10; //페이지 내비게이션 크기
    int totalPage; // 전체 페이지의 갯수
    int page; // 현재 페이지
    int beginPage; // 네비게이션의 첫번째 페이지
    int endPage; // 네비게이션의 마지막 파에지
    boolean showPrev; // 이전 페이지로 이동하는 링크를 보여줄 것인지의 여부
    boolean showNext; // 다음 페이지로 이동하는 링크를 보여줄 것인지의 여부

    public PageHandler(int totalCnt, int page) {
        this(totalCnt, page, 10);
    }

    public PageHandler(int totalCnt, int page, int pageSize) {
        this.totalCnt = totalCnt;
        this.page = page;
        this.pageSize = pageSize;

        totalPage = (int) Math.ceil(totalCnt / pageSize);
        beginPage =

    }
}
