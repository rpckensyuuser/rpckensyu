package com.app_kensyu.form;

import java.util.List;

import javax.validation.Valid;

import lombok.Data;

@Data
public class InsertFormParam {

    @Valid
    private List<InsertForm> formDataList;

}
