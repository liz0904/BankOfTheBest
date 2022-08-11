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
public class com_example_bankofthebest_portfolio_portDBRealmProxy extends com.example.bankofthebest.portfolio.portDB
    implements RealmObjectProxy, com_example_bankofthebest_portfolio_portDBRealmProxyInterface {

    static final class portDBColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long classificationIndex;
        long titleIndex;
        long dateIndex;
        long contentIndex;
        long memoIndex;

        portDBColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("portDB");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.classificationIndex = addColumnDetails("classification", "classification", objectSchemaInfo);
            this.titleIndex = addColumnDetails("title", "title", objectSchemaInfo);
            this.dateIndex = addColumnDetails("date", "date", objectSchemaInfo);
            this.contentIndex = addColumnDetails("content", "content", objectSchemaInfo);
            this.memoIndex = addColumnDetails("memo", "memo", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        portDBColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new portDBColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final portDBColumnInfo src = (portDBColumnInfo) rawSrc;
            final portDBColumnInfo dst = (portDBColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.classificationIndex = src.classificationIndex;
            dst.titleIndex = src.titleIndex;
            dst.dateIndex = src.dateIndex;
            dst.contentIndex = src.contentIndex;
            dst.memoIndex = src.memoIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private portDBColumnInfo columnInfo;
    private ProxyState<com.example.bankofthebest.portfolio.portDB> proxyState;

    com_example_bankofthebest_portfolio_portDBRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (portDBColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.bankofthebest.portfolio.portDB>(this);
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
    public String realmGet$classification() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.classificationIndex);
    }

    @Override
    public void realmSet$classification(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'classification' to null.");
            }
            row.getTable().setString(columnInfo.classificationIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'classification' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.classificationIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$title() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleIndex);
    }

    @Override
    public void realmSet$title(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'title' to null.");
            }
            row.getTable().setString(columnInfo.titleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'title' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.titleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$date() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.dateIndex);
    }

    @Override
    public void realmSet$date(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'date' to null.");
            }
            row.getTable().setString(columnInfo.dateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'date' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.dateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$content() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.contentIndex);
    }

    @Override
    public void realmSet$content(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'content' to null.");
            }
            row.getTable().setString(columnInfo.contentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'content' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.contentIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$memo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.memoIndex);
    }

    @Override
    public void realmSet$memo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'memo' to null.");
            }
            row.getTable().setString(columnInfo.memoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'memo' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.memoIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("portDB", 6, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("classification", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("date", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("content", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("memo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static portDBColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new portDBColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "portDB";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "portDB";
    }

    @SuppressWarnings("cast")
    public static com.example.bankofthebest.portfolio.portDB createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.bankofthebest.portfolio.portDB obj = null;
        if (update) {
            Table table = realm.getTable(com.example.bankofthebest.portfolio.portDB.class);
            portDBColumnInfo columnInfo = (portDBColumnInfo) realm.getSchema().getColumnInfo(com.example.bankofthebest.portfolio.portDB.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.bankofthebest.portfolio.portDB.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_example_bankofthebest_portfolio_portDBRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_example_bankofthebest_portfolio_portDBRealmProxy) realm.createObjectInternal(com.example.bankofthebest.portfolio.portDB.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_example_bankofthebest_portfolio_portDBRealmProxy) realm.createObjectInternal(com.example.bankofthebest.portfolio.portDB.class, json.getLong("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_example_bankofthebest_portfolio_portDBRealmProxyInterface objProxy = (com_example_bankofthebest_portfolio_portDBRealmProxyInterface) obj;
        if (json.has("classification")) {
            if (json.isNull("classification")) {
                objProxy.realmSet$classification(null);
            } else {
                objProxy.realmSet$classification((String) json.getString("classification"));
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                objProxy.realmSet$title(null);
            } else {
                objProxy.realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("date")) {
            if (json.isNull("date")) {
                objProxy.realmSet$date(null);
            } else {
                objProxy.realmSet$date((String) json.getString("date"));
            }
        }
        if (json.has("content")) {
            if (json.isNull("content")) {
                objProxy.realmSet$content(null);
            } else {
                objProxy.realmSet$content((String) json.getString("content"));
            }
        }
        if (json.has("memo")) {
            if (json.isNull("memo")) {
                objProxy.realmSet$memo(null);
            } else {
                objProxy.realmSet$memo((String) json.getString("memo"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.bankofthebest.portfolio.portDB createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.example.bankofthebest.portfolio.portDB obj = new com.example.bankofthebest.portfolio.portDB();
        final com_example_bankofthebest_portfolio_portDBRealmProxyInterface objProxy = (com_example_bankofthebest_portfolio_portDBRealmProxyInterface) obj;
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
            } else if (name.equals("classification")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$classification((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$classification(null);
                }
            } else if (name.equals("title")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$title((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$title(null);
                }
            } else if (name.equals("date")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$date((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$date(null);
                }
            } else if (name.equals("content")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$content((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$content(null);
                }
            } else if (name.equals("memo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$memo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$memo(null);
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

    private static com_example_bankofthebest_portfolio_portDBRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.example.bankofthebest.portfolio.portDB.class), false, Collections.<String>emptyList());
        io.realm.com_example_bankofthebest_portfolio_portDBRealmProxy obj = new io.realm.com_example_bankofthebest_portfolio_portDBRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.example.bankofthebest.portfolio.portDB copyOrUpdate(Realm realm, portDBColumnInfo columnInfo, com.example.bankofthebest.portfolio.portDB object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.example.bankofthebest.portfolio.portDB) cachedRealmObject;
        }

        com.example.bankofthebest.portfolio.portDB realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.example.bankofthebest.portfolio.portDB.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_example_bankofthebest_portfolio_portDBRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.example.bankofthebest.portfolio.portDB copy(Realm realm, portDBColumnInfo columnInfo, com.example.bankofthebest.portfolio.portDB newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.bankofthebest.portfolio.portDB) cachedRealmObject;
        }

        com_example_bankofthebest_portfolio_portDBRealmProxyInterface realmObjectSource = (com_example_bankofthebest_portfolio_portDBRealmProxyInterface) newObject;

        Table table = realm.getTable(com.example.bankofthebest.portfolio.portDB.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.classificationIndex, realmObjectSource.realmGet$classification());
        builder.addString(columnInfo.titleIndex, realmObjectSource.realmGet$title());
        builder.addString(columnInfo.dateIndex, realmObjectSource.realmGet$date());
        builder.addString(columnInfo.contentIndex, realmObjectSource.realmGet$content());
        builder.addString(columnInfo.memoIndex, realmObjectSource.realmGet$memo());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_example_bankofthebest_portfolio_portDBRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.example.bankofthebest.portfolio.portDB object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bankofthebest.portfolio.portDB.class);
        long tableNativePtr = table.getNativePtr();
        portDBColumnInfo columnInfo = (portDBColumnInfo) realm.getSchema().getColumnInfo(com.example.bankofthebest.portfolio.portDB.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$classification = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$classification();
        if (realmGet$classification != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.classificationIndex, rowIndex, realmGet$classification, false);
        }
        String realmGet$title = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$date = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
        }
        String realmGet$content = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$content();
        if (realmGet$content != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
        }
        String realmGet$memo = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$memo();
        if (realmGet$memo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.memoIndex, rowIndex, realmGet$memo, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bankofthebest.portfolio.portDB.class);
        long tableNativePtr = table.getNativePtr();
        portDBColumnInfo columnInfo = (portDBColumnInfo) realm.getSchema().getColumnInfo(com.example.bankofthebest.portfolio.portDB.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.bankofthebest.portfolio.portDB object = null;
        while (objects.hasNext()) {
            object = (com.example.bankofthebest.portfolio.portDB) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$classification = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$classification();
            if (realmGet$classification != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.classificationIndex, rowIndex, realmGet$classification, false);
            }
            String realmGet$title = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            }
            String realmGet$date = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$date();
            if (realmGet$date != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
            }
            String realmGet$content = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$content();
            if (realmGet$content != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
            }
            String realmGet$memo = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$memo();
            if (realmGet$memo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.memoIndex, rowIndex, realmGet$memo, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.bankofthebest.portfolio.portDB object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.bankofthebest.portfolio.portDB.class);
        long tableNativePtr = table.getNativePtr();
        portDBColumnInfo columnInfo = (portDBColumnInfo) realm.getSchema().getColumnInfo(com.example.bankofthebest.portfolio.portDB.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$classification = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$classification();
        if (realmGet$classification != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.classificationIndex, rowIndex, realmGet$classification, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.classificationIndex, rowIndex, false);
        }
        String realmGet$title = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$date = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
        }
        String realmGet$content = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$content();
        if (realmGet$content != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contentIndex, rowIndex, false);
        }
        String realmGet$memo = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$memo();
        if (realmGet$memo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.memoIndex, rowIndex, realmGet$memo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.memoIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.bankofthebest.portfolio.portDB.class);
        long tableNativePtr = table.getNativePtr();
        portDBColumnInfo columnInfo = (portDBColumnInfo) realm.getSchema().getColumnInfo(com.example.bankofthebest.portfolio.portDB.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.bankofthebest.portfolio.portDB object = null;
        while (objects.hasNext()) {
            object = (com.example.bankofthebest.portfolio.portDB) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$classification = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$classification();
            if (realmGet$classification != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.classificationIndex, rowIndex, realmGet$classification, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.classificationIndex, rowIndex, false);
            }
            String realmGet$title = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
            }
            String realmGet$date = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$date();
            if (realmGet$date != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
            }
            String realmGet$content = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$content();
            if (realmGet$content != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.contentIndex, rowIndex, false);
            }
            String realmGet$memo = ((com_example_bankofthebest_portfolio_portDBRealmProxyInterface) object).realmGet$memo();
            if (realmGet$memo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.memoIndex, rowIndex, realmGet$memo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.memoIndex, rowIndex, false);
            }
        }
    }

    public static com.example.bankofthebest.portfolio.portDB createDetachedCopy(com.example.bankofthebest.portfolio.portDB realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.bankofthebest.portfolio.portDB unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.bankofthebest.portfolio.portDB();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.bankofthebest.portfolio.portDB) cachedObject.object;
            }
            unmanagedObject = (com.example.bankofthebest.portfolio.portDB) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_bankofthebest_portfolio_portDBRealmProxyInterface unmanagedCopy = (com_example_bankofthebest_portfolio_portDBRealmProxyInterface) unmanagedObject;
        com_example_bankofthebest_portfolio_portDBRealmProxyInterface realmSource = (com_example_bankofthebest_portfolio_portDBRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$classification(realmSource.realmGet$classification());
        unmanagedCopy.realmSet$title(realmSource.realmGet$title());
        unmanagedCopy.realmSet$date(realmSource.realmGet$date());
        unmanagedCopy.realmSet$content(realmSource.realmGet$content());
        unmanagedCopy.realmSet$memo(realmSource.realmGet$memo());

        return unmanagedObject;
    }

    static com.example.bankofthebest.portfolio.portDB update(Realm realm, portDBColumnInfo columnInfo, com.example.bankofthebest.portfolio.portDB realmObject, com.example.bankofthebest.portfolio.portDB newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_example_bankofthebest_portfolio_portDBRealmProxyInterface realmObjectTarget = (com_example_bankofthebest_portfolio_portDBRealmProxyInterface) realmObject;
        com_example_bankofthebest_portfolio_portDBRealmProxyInterface realmObjectSource = (com_example_bankofthebest_portfolio_portDBRealmProxyInterface) newObject;
        Table table = realm.getTable(com.example.bankofthebest.portfolio.portDB.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.classificationIndex, realmObjectSource.realmGet$classification());
        builder.addString(columnInfo.titleIndex, realmObjectSource.realmGet$title());
        builder.addString(columnInfo.dateIndex, realmObjectSource.realmGet$date());
        builder.addString(columnInfo.contentIndex, realmObjectSource.realmGet$content());
        builder.addString(columnInfo.memoIndex, realmObjectSource.realmGet$memo());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("portDB = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{classification:");
        stringBuilder.append(realmGet$classification());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{date:");
        stringBuilder.append(realmGet$date());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{content:");
        stringBuilder.append(realmGet$content());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{memo:");
        stringBuilder.append(realmGet$memo());
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
        com_example_bankofthebest_portfolio_portDBRealmProxy aportDB = (com_example_bankofthebest_portfolio_portDBRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aportDB.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aportDB.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aportDB.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
