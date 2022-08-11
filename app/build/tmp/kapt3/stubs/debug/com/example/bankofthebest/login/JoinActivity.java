package com.example.bankofthebest.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010/\u001a\u000200J\u0012\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u000103H\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010!\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001a\u0010$\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001a\u0010\'\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR\u0019\u0010*\u001a\n ,*\u0004\u0018\u00010+0+\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/example/bankofthebest/login/JoinActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "idCheck", "", "getIdCheck", "()Z", "setIdCheck", "(Z)V", "joinDone", "Landroid/widget/Button;", "getJoinDone", "()Landroid/widget/Button;", "setJoinDone", "(Landroid/widget/Button;)V", "joinEmail", "Landroid/widget/EditText;", "getJoinEmail", "()Landroid/widget/EditText;", "setJoinEmail", "(Landroid/widget/EditText;)V", "joinId", "getJoinId", "setJoinId", "joinIdCheck", "getJoinIdCheck", "setJoinIdCheck", "joinName", "getJoinName", "setJoinName", "joinPhone", "getJoinPhone", "setJoinPhone", "joinPwd", "getJoinPwd", "setJoinPwd", "loginRealm", "Lio/realm/Realm;", "kotlin.jvm.PlatformType", "getLoginRealm", "()Lio/realm/Realm;", "join", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class JoinActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText joinId;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText joinPwd;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText joinEmail;
    @org.jetbrains.annotations.NotNull()
    public android.widget.Button joinIdCheck;
    @org.jetbrains.annotations.NotNull()
    public android.widget.Button joinDone;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText joinName;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText joinPhone;
    private final io.realm.Realm loginRealm = null;
    @org.jetbrains.annotations.Nullable()
    private android.os.Handler handler;
    private boolean idCheck = false;
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getJoinId() {
        return null;
    }
    
    public final void setJoinId(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getJoinPwd() {
        return null;
    }
    
    public final void setJoinPwd(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getJoinEmail() {
        return null;
    }
    
    public final void setJoinEmail(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getJoinIdCheck() {
        return null;
    }
    
    public final void setJoinIdCheck(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getJoinDone() {
        return null;
    }
    
    public final void setJoinDone(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getJoinName() {
        return null;
    }
    
    public final void setJoinName(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getJoinPhone() {
        return null;
    }
    
    public final void setJoinPhone(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    public final io.realm.Realm getLoginRealm() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.os.Handler getHandler() {
        return null;
    }
    
    public final void setHandler(@org.jetbrains.annotations.Nullable()
    android.os.Handler p0) {
    }
    
    public final boolean getIdCheck() {
        return false;
    }
    
    public final void setIdCheck(boolean p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void join() {
    }
    
    public JoinActivity() {
        super();
    }
}