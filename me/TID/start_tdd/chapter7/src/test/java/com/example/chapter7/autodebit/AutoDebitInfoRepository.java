package com.example.chapter7.autodebit;

public interface AutoDebitInfoRepository {
    void save(AutoDebitInfo info);
    AutoDebitInfo findOne(String userId);
}
