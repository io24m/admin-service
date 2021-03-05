//package com.github.io24m.adminservice.module.validate.data;
//
//import com.github.io24m.validate4java.validator.dict.Dict;
//import com.github.io24m.validate4java.validator.empty.Empty;
//import lombok.Data;
//
///**
// * @author lk1
// * @description
// * @create 2021-02-07 9:45
// */
//@Data
//public class Person {
//    @Empty(errorMessage = "姓名不能为空")
//    @Dict(dictKey = "name", errorMessage = "name dict error")
//    private String name;
//
//    @Empty(errorMessage = "年龄不能为空")
//    @Dict(dictKey = "age", errorMessage = "age dict error")
//    private String age;
//
//    @Empty(errorMessage = "birthday不能为空")
//    @Dict(dictKey = "birthday", errorMessage = "birthday dict error")
//    private String birthday;
//
//}
