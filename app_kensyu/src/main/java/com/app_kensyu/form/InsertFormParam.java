package com.app_kensyu.form;

import java.util.ArrayList;

import javax.validation.Valid;

import lombok.Data;

@Data
public class InsertFormParam {

    @Valid
    private ArrayList<InsertForm> formDataList;

}
