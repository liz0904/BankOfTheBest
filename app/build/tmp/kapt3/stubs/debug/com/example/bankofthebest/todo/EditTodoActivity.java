package com.example.bankofthebest.todo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020*H\u0002J\b\u0010.\u001a\u00020*H\u0002J\b\u0010/\u001a\u000200H\u0002J\u0012\u00101\u001a\u00020*2\b\u00102\u001a\u0004\u0018\u000103H\u0014J\b\u00104\u001a\u00020*H\u0014J\u0010\u00105\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0019\u0010!\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u001a\u0010#\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001a\u0010&\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0019\"\u0004\b(\u0010\u001b\u00a8\u00066"}, d2 = {"Lcom/example/bankofthebest/todo/EditTodoActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "calendar", "Ljava/util/Calendar;", "getCalendar", "()Ljava/util/Calendar;", "calendarView", "Landroid/widget/CalendarView;", "getCalendarView", "()Landroid/widget/CalendarView;", "setCalendarView", "(Landroid/widget/CalendarView;)V", "deleteFab", "Landroid/widget/Button;", "getDeleteFab", "()Landroid/widget/Button;", "setDeleteFab", "(Landroid/widget/Button;)V", "doneFab", "getDoneFab", "setDoneFab", "input_bank", "Landroid/widget/EditText;", "getInput_bank", "()Landroid/widget/EditText;", "setInput_bank", "(Landroid/widget/EditText;)V", "loginRealm", "Lio/realm/Realm;", "kotlin.jvm.PlatformType", "getLoginRealm", "()Lio/realm/Realm;", "realm", "getRealm", "subEditText", "getSubEditText", "setSubEditText", "todoEditText", "getTodoEditText", "setTodoEditText", "deleteTodo", "", "id", "", "insertMode", "insertTodo", "nextId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "updateMode", "app_debug"})
public final class EditTodoActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public android.widget.CalendarView calendarView;
    @org.jetbrains.annotations.NotNull()
    public android.widget.Button deleteFab;
    @org.jetbrains.annotations.NotNull()
    public android.widget.Button doneFab;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText todoEditText;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText subEditText;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText input_bank;
    private final io.realm.Realm loginRealm = null;
    private final io.realm.Realm realm = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Calendar calendar = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.CalendarView getCalendarView() {
        return null;
    }
    
    public final void setCalendarView(@org.jetbrains.annotations.NotNull()
    android.widget.CalendarView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getDeleteFab() {
        return null;
    }
    
    public final void setDeleteFab(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getDoneFab() {
        return null;
    }
    
    public final void setDoneFab(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getTodoEditText() {
        return null;
    }
    
    public final void setTodoEditText(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getSubEditText() {
        return null;
    }
    
    public final void setSubEditText(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getInput_bank() {
        return null;
    }
    
    public final void setInput_bank(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    public final io.realm.Realm getLoginRealm() {
        return null;
    }
    
    public final io.realm.Realm getRealm() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Calendar getCalendar() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void insertMode() {
    }
    
    private final void updateMode(long id) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final void insertTodo() {
    }
    
    private final void deleteTodo(long id) {
    }
    
    private final int nextId() {
        return 0;
    }
    
    public EditTodoActivity() {
        super();
    }
}