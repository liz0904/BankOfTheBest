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
public class com_example_bankofthebest_todo_TodoRealmProxy extends com.example.bankofthebest.todo.Todo
    implements RealmObjectProxy, com_example_bankofthebest_todo_TodoRealmProxyInterface {

    static final class TodoColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long usernameIndex;
        long account_list_out_numberIndex;
        long account_list_out_moneyIndex;
        long account_list_bankIndex;
        long dateIndex;
        long usermoneyIndex;

        TodoColumnInfo(OsSchemaInfo schemaInfo) {
            super(7);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Todo");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.usernameIndex = addColumnDetails("username", "username", objectSchemaInfo);
            this.account_list_out_numberIndex = addColumnDetails("account_list_out_number", "account_list_out_number", objectSchemaInfo);
            this.account_list_out_moneyIndex = addColumnDetails("account_list_out_money", "account_list_out_money", objectSchemaInfo);
            this.account_list_bankIndex = addColumnDetails("account_list_bank", "account_list_bank", objectSchemaInfo);
            this.dateIndex = addColumnDetails("date", "date", objectSchemaInfo);
            this.usermoneyIndex = addColumnDetails("usermoney", "usermoney", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        TodoColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new TodoColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final TodoColumnInfo src = (TodoColumnInfo) rawSrc;
            final TodoColumnInfo dst = (TodoColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.usernameIndex = src.usernameIndex;
            dst.account_list_out_numberIndex = src.account_list_out_numberIndex;
            dst.account_list_out_moneyIndex = src.account_list_out_moneyIndex;
            dst.account_list_bankIndex = src.account_list_bankIndex;
            dst.dateIndex = src.dateIndex;
            dst.usermoneyIndex = src.usermoneyIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private TodoColumnInfo columnInfo;
    private ProxyState<com.example.bankofthebest.todo.Todo> proxyState;

    com_example_bankofthebest_todo_TodoRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (TodoColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.bankofthebest.todo.Todo>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(long value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
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
    public String realmGet$account_list_out_number() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.account_list_out_numberIndex);
    }

    @Override
    public void realmSet$account_list_out_number(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'account_list_out_number' to null.");
            }
            row.getTable().setString(columnInfo.account_list_out_numberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'account_list_out_number' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.account_list_out_numberIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$account_list_out_money() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.account_list_out_moneyIndex);
    }

    @Override
    public void realmSet$account_list_out_money(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'account_list_out_money' to null.");
            }
            row.getTable().setString(columnInfo.account_list_out_moneyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'account_list_out_money' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.account_list_out_moneyIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$account_list_bank() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.account_list_bankIndex);
    }

    @Override
    public void realmSet$account_list_bank(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'account_list_bank' to null.");
            }
            row.getTable().setString(columnInfo.account_list_bankIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'account_list_bank' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.account_list_bankIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$date() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.dateIndex);
    }

    @Override
    public void realmSet$date(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.dateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.dateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$usermoney() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.usermoneyIndex);
    }

    @Override
    public void realmSet$usermoney(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.usermoneyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.usermoneyIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Todo", 7, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("username", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("account_list_out_number", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("account_list_out_money", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("account_list_bank", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("date", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("usermoney", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static TodoColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new TodoColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Todo";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Todo";
    }

    @SuppressWarnings("cast")
    public static com.example.bankofthebest.todo.Todo createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.bankofthebest.todo.Todo obj = null;
        if (update) {
            Table table = realm.getTable(com.example.bankofthebest.todo.Todo.class);
            TodoColumnInfo columnInfo = (TodoColumnInfo) realm.getSchema().getColumnInfo(com.example.bankofthebest.todo.Todo.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.bankofthebest.todo.Todo.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_example_bankofthebest_todo_TodoRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_example_bankofthebest_todo_TodoRealmProxy) realm.createObjectInternal(com.example.bankofthebest.todo.Todo.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_example_bankofthebest_todo_TodoRealmProxy) realm.createObjectInternal(com.example.bankofthebest.todo.Todo.class, json.getLong("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_example_bankofthebest_todo_TodoRealmProxyInterface objProxy = (com_example_bankofthebest_todo_TodoRealmProxyInterface) obj;
        if (json.has("username")) {
            if (json.isNull("username")) {
                objProxy.realmSet$username(null);
            } else {
                objProxy.realmSet$username((String) json.getString("username"));
            }
        }
        if (json.has("account_list_out_number")) {
            if (json.isNull("account_list_out_number")) {
                objProxy.realmSet$account_list_out_number(null);
            } else {
                objProxy.realmSet$account_list_out_number((String) json.getString("account_list_out_number"));
            }
        }
        if (json.has("account_list_out_money")) {
            if (json.isNull("account_list_out_money")) {
                objProxy.realmSet$account_list_out_money(null);
            } else {
                objProxy.realmSet$account_list_out_money((String) json.getString("account_list_out_money"));
            }
        }
        if (json.has("account_list_bank")) {
            if (json.isNull("account_list_bank")) {
                objProxy.realmSet$account_list_bank(null);
            } else {
                objProxy.realmSet$account_list_bank((String) json.getString("account_list_bank"));
            }
        }
        if (json.has("date")) {
            if (json.isNull("date")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'date' to null.");
            } else {
                objProxy.realmSet$date((long) json.getLong("date"));
            }
        }
        if (json.has("usermoney")) {
            if (json.isNull("usermoney")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'usermoney' to null.");
            } else {
                objProxy.realmSet$usermoney((int) json.getInt("usermoney"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.bankofthebest.todo.Todo createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.example.bankofthebest.todo.Todo obj = new com.example.bankofthebest.todo.Todo();
        final com_example_bankofthebest_todo_TodoRealmProxyInterface objProxy = (com_example_bankofthebest_todo_TodoRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("username")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$username((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$username(null);
                }
            } else if (name.equals("account_list_out_number")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$account_list_out_number((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$account_list_out_number(null);
                }
            } else if (name.equals("account_list_out_money")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$account_list_out_money((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$account_list_out_money(null);
                }
            } else if (name.equals("account_list_bank")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$account_list_bank((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$account_list_bank(null);
                }
            } else if (name.equals("date")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$date((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'date' to null.");
                }
            } else if (name.equals("usermoney")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$usermoney((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'usermoney' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_example_bankofthebest_todo_TodoRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.example.bankofthebest.todo.Todo.class), false, Collections.<String>emptyList());
        io.realm.com_example_bankofthebest_todo_TodoRealmProxy obj = new io.realm.com_example_bankofthebest_todo_TodoRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.example.bankofthebest.todo.Todo copyOrUpdate(Realm realm, TodoColumnInfo columnInfo, com.example.bankofthebest.todo.Todo object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.example.bankofthebest.todo.Todo) cachedRealmObject;
        }

        com.example.bankofthebest.todo.Todo realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.example.bankofthebest.todo.Todo.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_example_bankofthebest_todo_TodoRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.example.bankofthebest.todo.Todo copy(Realm realm, TodoColumnInfo columnInfo, com.example.bankofthebest.todo.Todo newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.bankofthebest.todo.Todo) cachedRealmObject;
        }

        com_example_bankofthebest_todo_TodoRealmProxyInterface realmObjectSource = (com_example_bankofthebest_todo_TodoRealmProxyInterface) newObject;

        Table table = realm.getTable(com.example.bankofthebest.todo.Todo.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.usernameIndex, realmObjectSource.realmGet$username());
        builder.addString(columnInfo.account_list_out_numberIndex, realmObjectSource.realmGet$account_list_out_number());
        builder.addString(columnInfo.account_list_out_moneyIndex, realmObjectSource.realmGet$account_list_out_money());
        builder.addString(columnInfo.account_list_bankIndex, realmObjectSource.realmGet$account_list_bank());
        builder.addInteger(columnInfo.dateIndex, realmObjectSource.realmGet$date());
        builder.addInteger(columnInfo.usermoneyIndex, realmObjectSource.realmGet$usermoney());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_example_bankofthebest_todo_TodoRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.example.bankofthebest.todo.Todo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bankofthebest.todo.Todo.class);
        long tableNativePtr = table.getNativePtr();
        TodoColumnInfo columnInfo = (TodoColumnInfo) realm.getSchema().getColumnInfo(com.example.bankofthebest.todo.Todo.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$username = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$username();
        if (realmGet$username != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
        }
        String realmGet$account_list_out_number = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$account_list_out_number();
        if (realmGet$account_list_out_number != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.account_list_out_numberIndex, rowIndex, realmGet$account_list_out_number, false);
        }
        String realmGet$account_list_out_money = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$account_list_out_money();
        if (realmGet$account_list_out_money != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.account_list_out_moneyIndex, rowIndex, realmGet$account_list_out_money, false);
        }
        String realmGet$account_list_bank = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$account_list_bank();
        if (realmGet$account_list_bank != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.account_list_bankIndex, rowIndex, realmGet$account_list_bank, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.dateIndex, rowIndex, ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$date(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.usermoneyIndex, rowIndex, ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$usermoney(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bankofthebest.todo.Todo.class);
        long tableNativePtr = table.getNativePtr();
        TodoColumnInfo columnInfo = (TodoColumnInfo) realm.getSchema().getColumnInfo(com.example.bankofthebest.todo.Todo.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.bankofthebest.todo.Todo object = null;
        while (objects.hasNext()) {
            object = (com.example.bankofthebest.todo.Todo) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$username = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$username();
            if (realmGet$username != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
            }
            String realmGet$account_list_out_number = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$account_list_out_number();
            if (realmGet$account_list_out_number != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.account_list_out_numberIndex, rowIndex, realmGet$account_list_out_number, false);
            }
            String realmGet$account_list_out_money = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$account_list_out_money();
            if (realmGet$account_list_out_money != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.account_list_out_moneyIndex, rowIndex, realmGet$account_list_out_money, false);
            }
            String realmGet$account_list_bank = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$account_list_bank();
            if (realmGet$account_list_bank != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.account_list_bankIndex, rowIndex, realmGet$account_list_bank, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.dateIndex, rowIndex, ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$date(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.usermoneyIndex, rowIndex, ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$usermoney(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.bankofthebest.todo.Todo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bankofthebest.todo.Todo.class);
        long tableNativePtr = table.getNativePtr();
        TodoColumnInfo columnInfo = (TodoColumnInfo) realm.getSchema().getColumnInfo(com.example.bankofthebest.todo.Todo.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$username = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$username();
        if (realmGet$username != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.usernameIndex, rowIndex, false);
        }
        String realmGet$account_list_out_number = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$account_list_out_number();
        if (realmGet$account_list_out_number != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.account_list_out_numberIndex, rowIndex, realmGet$account_list_out_number, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.account_list_out_numberIndex, rowIndex, false);
        }
        String realmGet$account_list_out_money = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$account_list_out_money();
        if (realmGet$account_list_out_money != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.account_list_out_moneyIndex, rowIndex, realmGet$account_list_out_money, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.account_list_out_moneyIndex, rowIndex, false);
        }
        String realmGet$account_list_bank = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$account_list_bank();
        if (realmGet$account_list_bank != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.account_list_bankIndex, rowIndex, realmGet$account_list_bank, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.account_list_bankIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.dateIndex, rowIndex, ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$date(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.usermoneyIndex, rowIndex, ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$usermoney(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bankofthebest.todo.Todo.class);
        long tableNativePtr = table.getNativePtr();
        TodoColumnInfo columnInfo = (TodoColumnInfo) realm.getSchema().getColumnInfo(com.example.bankofthebest.todo.Todo.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.bankofthebest.todo.Todo object = null;
        while (objects.hasNext()) {
            object = (com.example.bankofthebest.todo.Todo) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$username = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$username();
            if (realmGet$username != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.usernameIndex, rowIndex, false);
            }
            String realmGet$account_list_out_number = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$account_list_out_number();
            if (realmGet$account_list_out_number != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.account_list_out_numberIndex, rowIndex, realmGet$account_list_out_number, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.account_list_out_numberIndex, rowIndex, false);
            }
            String realmGet$account_list_out_money = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$account_list_out_money();
            if (realmGet$account_list_out_money != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.account_list_out_moneyIndex, rowIndex, realmGet$account_list_out_money, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.account_list_out_moneyIndex, rowIndex, false);
            }
            String realmGet$account_list_bank = ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$account_list_bank();
            if (realmGet$account_list_bank != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.account_list_bankIndex, rowIndex, realmGet$account_list_bank, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.account_list_bankIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.dateIndex, rowIndex, ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$date(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.usermoneyIndex, rowIndex, ((com_example_bankofthebest_todo_TodoRealmProxyInterface) object).realmGet$usermoney(), false);
        }
    }

    public static com.example.bankofthebest.todo.Todo createDetachedCopy(com.example.bankofthebest.todo.Todo realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.bankofthebest.todo.Todo unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.bankofthebest.todo.Todo();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.bankofthebest.todo.Todo) cachedObject.object;
            }
            unmanagedObject = (com.example.bankofthebest.todo.Todo) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_bankofthebest_todo_TodoRealmProxyInterface unmanagedCopy = (com_example_bankofthebest_todo_TodoRealmProxyInterface) unmanagedObject;
        com_example_bankofthebest_todo_TodoRealmProxyInterface realmSource = (com_example_bankofthebest_todo_TodoRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$username(realmSource.realmGet$username());
        unmanagedCopy.realmSet$account_list_out_number(realmSource.realmGet$account_list_out_number());
        unmanagedCopy.realmSet$account_list_out_money(realmSource.realmGet$account_list_out_money());
        unmanagedCopy.realmSet$account_list_bank(realmSource.realmGet$account_list_bank());
        unmanagedCopy.realmSet$date(realmSource.realmGet$date());
        unmanagedCopy.realmSet$usermoney(realmSource.realmGet$usermoney());

        return unmanagedObject;
    }

    static com.example.bankofthebest.todo.Todo update(Realm realm, TodoColumnInfo columnInfo, com.example.bankofthebest.todo.Todo realmObject, com.example.bankofthebest.todo.Todo newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_example_bankofthebest_todo_TodoRealmProxyInterface realmObjectTarget = (com_example_bankofthebest_todo_TodoRealmProxyInterface) realmObject;
        com_example_bankofthebest_todo_TodoRealmProxyInterface realmObjectSource = (com_example_bankofthebest_todo_TodoRealmProxyInterface) newObject;
        Table table = realm.getTable(com.example.bankofthebest.todo.Todo.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.usernameIndex, realmObjectSource.realmGet$username());
        builder.addString(columnInfo.account_list_out_numberIndex, realmObjectSource.realmGet$account_list_out_number());
        builder.addString(columnInfo.account_list_out_moneyIndex, realmObjectSource.realmGet$account_list_out_money());
        builder.addString(columnInfo.account_list_bankIndex, realmObjectSource.realmGet$account_list_bank());
        builder.addInteger(columnInfo.dateIndex, realmObjectSource.realmGet$date());
        builder.addInteger(columnInfo.usermoneyIndex, realmObjectSource.realmGet$usermoney());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Todo = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{username:");
        stringBuilder.append(realmGet$username());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{account_list_out_number:");
        stringBuilder.append(realmGet$account_list_out_number());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{account_list_out_money:");
        stringBuilder.append(realmGet$account_list_out_money());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{account_list_bank:");
        stringBuilder.append(realmGet$account_list_bank());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{date:");
        stringBuilder.append(realmGet$date());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{usermoney:");
        stringBuilder.append(realmGet$usermoney());
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
        com_example_bankofthebest_todo_TodoRealmProxy aTodo = (com_example_bankofthebest_todo_TodoRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aTodo.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aTodo.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aTodo.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
