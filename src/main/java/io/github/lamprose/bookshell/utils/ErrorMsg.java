package io.github.lamprose.bookshell.utils;

public interface ErrorMsg {
    String NOT_FOUND = "获取失败，请检查后重试";
    String INSERT_ERROR = "添加失败，请检查数据格式重试";
    String UPDATE_ERROR = "更新数据失败，请检查数据格式后重试";
    String DELETE_ERROR = "删除数据失败，请检查后重试";
}
