package com.jof.springmvc.form;

public class ReviewForm {

    private Long game_id;

    private String title;

    private String body;

    private boolean positive;

    private Long target_user_id;

    private Long source_user_id;

    public Long getSource_user_id() {
        return source_user_id;
    }

    public void setSource_user_id(Long source_user_id) {
        this.source_user_id = source_user_id;
    }

    public Long getTarget_user_id() {
        return target_user_id;
    }

    public void setTarget_user_id(Long target_user_id) {
        this.target_user_id = target_user_id;
    }

    public Long getGame_id() {
        return game_id;
    }

    public void setGame_id(Long game_id) {
        this.game_id = game_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }

}
