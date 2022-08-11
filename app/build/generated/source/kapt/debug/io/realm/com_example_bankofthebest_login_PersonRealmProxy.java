package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_example_bankofthebest_login_PersonRealmProxy extends com.example.bankofthebest.login.Person
    implements RealmObjectProxy, com_example_bankofthebest_login_PersonRealmProxyInterface {

    static final class PersonColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long pwdIndex;
        long usernameIndex;
        long emailIndex;
        long phoneIndex;
        long moneyIndex;
        long accountIndex;
        long saving_moneyIndex;

        PersonColumnInfo(OsSchemaInfo schemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Person");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.pwdIndex = addColumnDetails("pwd", "pwd", objectSchemaInfo);
            this.usernameIndex = addColumnDetails("username", "username", objectSchemaInfo);
            this.emailIndex = addColumnDetails("email", "email", objectSchemaInfo);
            this.phoneIndex = addColumnDetails("phone", "phone", objectSchemaInfo);
            this.moneyIndex = addColumnDetails("money", "money", objectSchemaInfo);
            this.accountIndex = addColumnDetails("account", "account", objectSchemaInfo);
            this.saving_moneyIndex = addColumnDetails("saving_money", "saving_money", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        PersonColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PersonColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PersonColumnInfo src = (PersonColumnInfo) rawSrc;
            final PersonColumnInfo dst = (PersonColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.pwdIndex = src.pwdIndex;
            dst.usernameIndex = src.usernameIndex;
            dst.emailIndex = src.emailIndex;
            dst.phoneIndex = src.phoneIndex;
            dst.moneyIndex = src.moneyIndex;
            dst.accountIndex = src.accountIndex;
            dst.saving_moneyIndex = src.saving_moneyIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PersonColumnInfo columnInfo;
    private ProxyState<com.example.bankofthebest.login.Person> proxyState;

    com_example_bankofthebest_login_PersonRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PersonColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.bankofthebest.login.Person>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
            }
            row.getTable().setString(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$pwd() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.pwdIndex);
    }

    @Override
    public void realmSet$pwd(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'pwd' to null.");
            }
            row.getTable().setString(columnInfo.pwdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'pwd' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.pwdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$username() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.usernameIndex);
    }

    @Override
    public void realmSet$username(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'username' to null.");
            }
            row.getTable().setString(columnInfo.usernameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'username' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.usernameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$email() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailIndex);
    }

    @Override
    public void realmSet$email(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'email' to null.");
            }
            row.getTable().setString(columnInfo.emailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'email' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.emailIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$phone() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.phoneIndex);
    }

    @Override
    public void realmSet$phone(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'phone' to null.");
            }
            row.getTable().setString(columnInfo.phoneIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'phone' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.phoneIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$money() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.moneyIndex);
    }

    @Override
    public void realmSet$money(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.moneyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.moneyIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$account() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.accountIndex);
    }

    @Override
    public void realmSet$account(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'account' to null.");
            }
            row.getTable().setString(columnInfo.accountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'account' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.accountIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$saving_money() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.saving_moneyIndex);
    }

    @Override
    public void realmSet$saving_money(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.saving_moneyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.saving_moneyIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Person", 8, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("pwd", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("username", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("phone", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("money", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("account", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("saving_money", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PersonColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PersonColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Person";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Person";
    }

    @SuppressWarnings("cast")
    public static com.example.bankofthebest.login.Person createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.bankofthebest.login.Person obj = realm.createObjectInternal(com.example.bankofthebest.login.Person.class, true, excludeFields);

        final com_example_bankofthebest_login_PersonRealmProxyInterface objProxy = (com_example_bankofthebest_login_PersonRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                objProxy.realmSet$id(null);
            } else {
                objProxy.realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("pwd")) {
            if (json.isNull("pwd")) {
                objProxy.realmSet$pwd(null);
            } else {
                objProxy.realmSet$pwd((String) json.getString("pwd"));
            }
        }
        if (json.has("username")) {
            if (json.isNull("username")) {
                objProxy.realmSet$username(null);
            } else {
                objProxy.realmSet$username((String) json.getString("username"));
            }
        }
        if (json.has("email")) {
            if (json.isNull("email")) {
                objProxy.realmSet$email(null);
            } else {
                objProxy.realmSet$email((String) json.getString("email"));
            }
        }
        if (json.has("phone")) {
            if (json.isNull("phone")) {
                objProxy.realmSet$phone(null);
            } else {
                objProxy.realmSet$phone((String) json.getString("phone"));
            }
        }
        if (json.has("money")) {
            if (json.isNull("money")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'money' to null.");
            } else {
                objProxy.realmSet$money((int) json.getInt("money"));
            }
        }
        if (json.has("account")) {
            if (json.isNull("account")) {
                objProxy.realmSet$account(null);
            } else {
                objProxy.realmSet$account((String) json.getString("account"));
            }
        }
        if (json.has("saving_money")) {
            if (json.isNull("saving_money")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'saving_money' to null.");
            } else {
                objProxy.realmSet$saving_money((int) json.getInt("saving_money"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.bankofthebest.login.Person createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.example.bankofthebest.login.Person obj = new com.example.bankofthebest.login.Person();
        final com_example_bankofthebest_login_PersonRealmProxyInterface objProxy = (com_example_bankofthebest_login_PersonRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
            } else if (name.equals("pwd")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$pwd((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$pwd(null);
                }
            } else if (name.equals("username")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$username((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$username(null);
                }
            } else if (name.equals("email")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$email((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$email(null);
                }
            } else if (name.equals("phone")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$phone((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$phone(null);
                }
            } else if (name.equals("money")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$money((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'money' to null.");
                }
            } else if (name.equals("account")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$account((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$account(null);
                }
            } else if (name.equals("saving_money")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$saving_money((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'saving_money' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_example_bankofthebest_login_PersonRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.example.bankofthebest.login.Person.class), false, Collections.<String>emptyList());
        io.realm.com_example_bankofthebest_login_PersonRealmProxy obj = new io.realm.com_example_bankofthebest_login_PersonRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.example.bankofthebest.login.Person copyOrUpdate(Realm realm, PersonColumnInfo columnInfo, com.example.bankofthebest.login.Person object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.bankofthebest.login.Person) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.example.bankofthebest.login.Person copy(Realm realm, PersonColumnInfo columnInfo, com.example.bankofthebest.login.Person newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.bankofthebest.login.Person) cachedRealmObject;
        }

        com_example_bankofthebest_login_PersonRealmProxyInterface realmObjectSource = (com_example_bankofthebest_login_PersonRealmProxyInterface) newObject;

        Table table = realm.getTable(com.example.bankofthebest.login.Person.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.pwdIndex, realmObjectSource.realmGet$pwd());
        builder.addString(columnInfo.usernameIndex, realmObjectSource.realmGet$username());
        builder.addString(columnInfo.emailIndex, realmObjectSource.realmGet$email());
        builder.addString(columnInfo.phoneIndex, realmObjectSource.realmGet$phone());
        builder.addInteger(columnInfo.moneyIndex, realmObjectSource.realmGet$money());
        builder.addString(columnInfo.accountIndex, realmObjectSource.realmGet$account());
        builder.addInteger(columnInfo.saving_moneyIndex, realmObjectSource.realmGet$saving_money());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_example_bankofthebest_login_PersonRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.example.bankofthebest.login.Person object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bankofthebest.login.Person.class);
        long tableNativePtr = table.getNativePtr();
        PersonColumnInfo columnInfo = (PersonColumnInfo) realm.getSchema().getColumnInfo(com.example.bankofthebest.login.Person.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$id = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        }
        String realmGet$pwd = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$pwd();
        if (realmGet$pwd != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pwdIndex, rowIndex, realmGet$pwd, false);
        }
        String realmGet$username = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$username();
        if (realmGet$username != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
        }
        String realmGet$email = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        }
        String realmGet$phone = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$phone();
        if (realmGet$phone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.moneyIndex, rowIndex, ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$money(), false);
        String realmGet$account = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$account();
        if (realmGet$account != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.accountIndex, rowIndex, realmGet$account, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.saving_moneyIndex, rowIndex, ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$saving_money(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bankofthebest.login.Person.class);
        long tableNativePtr = table.getNativePtr();
        PersonColumnInfo columnInfo = (PersonColumnInfo) realm.getSchema().getColumnInfo(com.example.bankofthebest.login.Person.class);
        com.example.bankofthebest.login.Person object = null;
        while (objects.hasNext()) {
            object = (com.example.bankofthebest.login.Person) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$id = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            }
            String realmGet$pwd = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$pwd();
            if (realmGet$pwd != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.pwdIndex, rowIndex, realmGet$pwd, false);
            }
            String realmGet$username = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$username();
            if (realmGet$username != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
            }
            String realmGet$email = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
            }
            String realmGet$phone = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$phone();
            if (realmGet$phone != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.moneyIndex, rowIndex, ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$money(), false);
            String realmGet$account = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$account();
            if (realmGet$account != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.accountIndex, rowIndex, realmGet$account, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.saving_moneyIndex, rowIndex, ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$saving_money(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.bankofthebest.login.Person object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bankofthebest.login.Person.class);
        long tableNativePtr = table.getNativePtr();
        PersonColumnInfo columnInfo = (PersonColumnInfo) realm.getSchema().getColumnInfo(com.example.bankofthebest.login.Person.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$id = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$pwd = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$pwd();
        if (realmGet$pwd != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pwdIndex, rowIndex, realmGet$pwd, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.pwdIndex, rowIndex, false);
        }
        String realmGet$username = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$username();
        if (realmGet$username != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.usernameIndex, rowIndex, false);
        }
        String realmGet$email = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
        }
        String realmGet$phone = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$phone();
        if (realmGet$phone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.phoneIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.moneyIndex, rowIndex, ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$money(), false);
        String realmGet$account = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$account();
        if (realmGet$account != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.accountIndex, rowIndex, realmGet$account, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.accountIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.saving_moneyIndex, rowIndex, ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$saving_money(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bankofthebest.login.Person.class);
        long tableNativePtr = table.getNativePtr();
        PersonColumnInfo columnInfo = (PersonColumnInfo) realm.getSchema().getColumnInfo(com.example.bankofthebest.login.Person.class);
        com.example.bankofthebest.login.Person object = null;
        while (objects.hasNext()) {
            object = (com.example.bankofthebest.login.Person) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$id = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
            }
            String realmGet$pwd = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$pwd();
            if (realmGet$pwd != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.pwdIndex, rowIndex, realmGet$pwd, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.pwdIndex, rowIndex, false);
            }
            String realmGet$username = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$username();
            if (realmGet$username != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.usernameIndex, rowIndex, false);
            }
            String realmGet$email = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
            }
            String realmGet$phone = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$phone();
            if (realmGet$phone != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.phoneIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.moneyIndex, rowIndex, ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$money(), false);
            String realmGet$account = ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$account();
            if (realmGet$account != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.accountIndex, rowIndex, realmGet$account, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.accountIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.saving_moneyIndex, rowIndex, ((com_example_bankofthebest_login_PersonRealmProxyInterface) object).realmGet$saving_money(), false);
        }
    }

    public static com.example.bankofthebest.login.Person createDetachedCopy(com.example.bankofthebest.login.Person realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.bankofthebest.login.Person unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.bankofthebest.login.Person();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.bankofthebest.login.Person) cachedObject.object;
            }
            unmanagedObject = (com.example.bankofthebest.login.Person) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_bankofthebest_login_PersonRealmProxyInterface unmanagedCopy = (com_example_bankofthebest_login_PersonRealmProxyInterface) unmanagedObject;
        com_example_bankofthebest_login_PersonRealmProxyInterface realmSource = (com_example_bankofthebest_login_PersonRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$pwd(realmSource.realmGet$pwd());
        unmanagedCopy.realmSet$username(realmSource.realmGet$username());
        unmanagedCopy.realmSet$email(realmSource.realmGet$email());
        unmanagedCopy.realmSet$phone(realmSource.realmGet$phone());
        unmanagedCopy.realmSet$money(realmSource.realmGet$money());
        unmanagedCopy.realmSet$account(realmSource.realmGet$account());
        unmanagedCopy.realmSet$saving_money(realmSource.realmGet$saving_money());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Person = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{pwd:");
        stringBuilder.append(realmGet$pwd());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{username:");
        stringBuilder.append(realmGet$username());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{email:");
        stringBuilder.append(realmGet$email());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{phone:");
        stringBuilder.append(realmGet$phone());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{money:");
        stringBuilder.append(realmGet$money());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{account:");
        stringBuilder.append(realmGet$account());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{saving_money:");
        stringBuilder.append(realmGet$saving_money());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_example_bankofthebest_login_PersonRealmProxy aPerson = (com_example_bankofthebest_login_PersonRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPerson.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPerson.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPerson.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
