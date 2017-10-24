@file:kotlinx.cinterop.InteropStubs
@file:Suppress("UNUSED_VARIABLE", "UNUSED_EXPRESSION")
package sqlite3

import konan.SymbolName
import kotlinx.cinterop.*
import cnames.structs.Fts5Context
import cnames.structs.Fts5Tokenizer
import cnames.structs.Mem
import cnames.structs.sqlite3
import cnames.structs.sqlite3_backup
import cnames.structs.sqlite3_blob
import cnames.structs.sqlite3_context
import cnames.structs.sqlite3_mutex
import cnames.structs.sqlite3_pcache
import cnames.structs.sqlite3_snapshot
import cnames.structs.sqlite3_stmt

fun sqlite3_libversion(): CPointer<ByteVar>? {
    return interpretCPointer<ByteVar>(kniBridge0())
}

fun sqlite3_sourceid(): CPointer<ByteVar>? {
    return interpretCPointer<ByteVar>(kniBridge1())
}

fun sqlite3_libversion_number(): Int {
    return kniBridge2()
}

fun sqlite3_compileoption_used(zOptName: String?): Int {
    memScoped {
        return kniBridge3(zOptName?.cstr?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_compileoption_get(N: Int): CPointer<ByteVar>? {
    return interpretCPointer<ByteVar>(kniBridge4(N))
}

fun sqlite3_threadsafe(): Int {
    return kniBridge5()
}

fun sqlite3_close(arg0: CValuesRef<sqlite3>?): Int {
    memScoped {
        return kniBridge6(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_close_v2(arg0: CValuesRef<sqlite3>?): Int {
    memScoped {
        return kniBridge7(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_exec(arg0: CValuesRef<sqlite3>?, sql: String?, callback: CPointer<CFunction<(COpaquePointer?, Int, CPointer<CPointerVar<ByteVar>>?, CPointer<CPointerVar<ByteVar>>?) -> Int>>?, arg3: CValuesRef<*>?, errmsg: CValuesRef<CPointerVar<ByteVar>>?): Int {
    memScoped {
        return kniBridge8(arg0?.getPointer(memScope).rawValue, sql?.cstr?.getPointer(memScope).rawValue, callback.rawValue, arg3?.getPointer(memScope).rawValue, errmsg?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_initialize(): Int {
    return kniBridge9()
}

fun sqlite3_shutdown(): Int {
    return kniBridge10()
}

fun sqlite3_os_init(): Int {
    return kniBridge11()
}

fun sqlite3_os_end(): Int {
    return kniBridge12()
}

fun sqlite3_config(arg0: Int, vararg variadicArguments: Any?): Int {
    memScoped {
        val kniResult = allocFfiReturnValueBuffer<IntVar>(typeOf<IntVar>())
        callWithVarargs(kniBridge13(), kniResult.rawPtr, FFI_TYPE_KIND_SINT32, arrayOf(arg0), variadicArguments, memScope)
        return kniResult.value
    }
}

fun sqlite3_db_config(arg0: CValuesRef<sqlite3>?, op: Int, vararg variadicArguments: Any?): Int {
    memScoped {
        val kniResult = allocFfiReturnValueBuffer<IntVar>(typeOf<IntVar>())
        callWithVarargs(kniBridge14(), kniResult.rawPtr, FFI_TYPE_KIND_SINT32, arrayOf(arg0?.getPointer(memScope), op), variadicArguments, memScope)
        return kniResult.value
    }
}

fun sqlite3_extended_result_codes(arg0: CValuesRef<sqlite3>?, onoff: Int): Int {
    memScoped {
        return kniBridge15(arg0?.getPointer(memScope).rawValue, onoff)
    }
}

fun sqlite3_last_insert_rowid(arg0: CValuesRef<sqlite3>?): sqlite3_int64 {
    memScoped {
        return kniBridge16(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_changes(arg0: CValuesRef<sqlite3>?): Int {
    memScoped {
        return kniBridge17(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_total_changes(arg0: CValuesRef<sqlite3>?): Int {
    memScoped {
        return kniBridge18(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_interrupt(arg0: CValuesRef<sqlite3>?): Unit {
    memScoped {
        return kniBridge19(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_complete(sql: String?): Int {
    memScoped {
        return kniBridge20(sql?.cstr?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_complete16(sql: CValuesRef<*>?): Int {
    memScoped {
        return kniBridge21(sql?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_busy_handler(arg0: CValuesRef<sqlite3>?, arg1: CPointer<CFunction<(COpaquePointer?, Int) -> Int>>?, arg2: CValuesRef<*>?): Int {
    memScoped {
        return kniBridge22(arg0?.getPointer(memScope).rawValue, arg1.rawValue, arg2?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_busy_timeout(arg0: CValuesRef<sqlite3>?, ms: Int): Int {
    memScoped {
        return kniBridge23(arg0?.getPointer(memScope).rawValue, ms)
    }
}

fun sqlite3_get_table(db: CValuesRef<sqlite3>?, zSql: String?, pazResult: CValuesRef<CPointerVar<CPointerVar<ByteVar>>>?, pnRow: CValuesRef<IntVar>?, pnColumn: CValuesRef<IntVar>?, pzErrmsg: CValuesRef<CPointerVar<ByteVar>>?): Int {
    memScoped {
        return kniBridge24(db?.getPointer(memScope).rawValue, zSql?.cstr?.getPointer(memScope).rawValue, pazResult?.getPointer(memScope).rawValue, pnRow?.getPointer(memScope).rawValue, pnColumn?.getPointer(memScope).rawValue, pzErrmsg?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_free_table(result: CValuesRef<CPointerVar<ByteVar>>?): Unit {
    memScoped {
        return kniBridge25(result?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_mprintf(arg0: String?, vararg variadicArguments: Any?): CPointer<ByteVar>? {
    memScoped {
        val kniResult = allocFfiReturnValueBuffer<CPointerVar<ByteVar>>(typeOf<CPointerVar<ByteVar>>())
        callWithVarargs(kniBridge26(), kniResult.rawPtr, FFI_TYPE_KIND_POINTER, arrayOf(arg0?.cstr?.getPointer(memScope)), variadicArguments, memScope)
        return kniResult.value
    }
}

fun sqlite3_vmprintf(arg0: String?, arg1: va_list?): CPointer<ByteVar>? {
    memScoped {
        return interpretCPointer<ByteVar>(kniBridge27(arg0?.cstr?.getPointer(memScope).rawValue, arg1.rawValue))
    }
}

fun sqlite3_snprintf(arg0: Int, arg1: CValuesRef<ByteVar>?, arg2: String?, vararg variadicArguments: Any?): CPointer<ByteVar>? {
    memScoped {
        val kniResult = allocFfiReturnValueBuffer<CPointerVar<ByteVar>>(typeOf<CPointerVar<ByteVar>>())
        callWithVarargs(kniBridge28(), kniResult.rawPtr, FFI_TYPE_KIND_POINTER, arrayOf(arg0, arg1?.getPointer(memScope), arg2?.cstr?.getPointer(memScope)), variadicArguments, memScope)
        return kniResult.value
    }
}

fun sqlite3_vsnprintf(arg0: Int, arg1: CValuesRef<ByteVar>?, arg2: String?, arg3: va_list?): CPointer<ByteVar>? {
    memScoped {
        return interpretCPointer<ByteVar>(kniBridge29(arg0, arg1?.getPointer(memScope).rawValue, arg2?.cstr?.getPointer(memScope).rawValue, arg3.rawValue))
    }
}

fun sqlite3_malloc(arg0: Int): COpaquePointer? {
    return interpretCPointer<COpaque>(kniBridge30(arg0))
}

fun sqlite3_malloc64(arg0: sqlite3_uint64): COpaquePointer? {
    return interpretCPointer<COpaque>(kniBridge31(arg0))
}

fun sqlite3_realloc(arg0: CValuesRef<*>?, arg1: Int): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge32(arg0?.getPointer(memScope).rawValue, arg1))
    }
}

fun sqlite3_realloc64(arg0: CValuesRef<*>?, arg1: sqlite3_uint64): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge33(arg0?.getPointer(memScope).rawValue, arg1))
    }
}

fun sqlite3_free(arg0: CValuesRef<*>?): Unit {
    memScoped {
        return kniBridge34(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_msize(arg0: CValuesRef<*>?): sqlite3_uint64 {
    memScoped {
        return kniBridge35(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_memory_used(): sqlite3_int64 {
    return kniBridge36()
}

fun sqlite3_memory_highwater(resetFlag: Int): sqlite3_int64 {
    return kniBridge37(resetFlag)
}

fun sqlite3_randomness(N: Int, P: CValuesRef<*>?): Unit {
    memScoped {
        return kniBridge38(N, P?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_set_authorizer(arg0: CValuesRef<sqlite3>?, xAuth: CPointer<CFunction<(COpaquePointer?, Int, CPointer<ByteVar>?, CPointer<ByteVar>?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> Int>>?, pUserData: CValuesRef<*>?): Int {
    memScoped {
        return kniBridge39(arg0?.getPointer(memScope).rawValue, xAuth.rawValue, pUserData?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_trace(arg0: CValuesRef<sqlite3>?, xTrace: CPointer<CFunction<(COpaquePointer?, CPointer<ByteVar>?) -> Unit>>?, arg2: CValuesRef<*>?): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge40(arg0?.getPointer(memScope).rawValue, xTrace.rawValue, arg2?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_profile(arg0: CValuesRef<sqlite3>?, xProfile: CPointer<CFunction<(COpaquePointer?, CPointer<ByteVar>?, sqlite3_uint64) -> Unit>>?, arg2: CValuesRef<*>?): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge41(arg0?.getPointer(memScope).rawValue, xProfile.rawValue, arg2?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_progress_handler(arg0: CValuesRef<sqlite3>?, arg1: Int, arg2: CPointer<CFunction<(COpaquePointer?) -> Int>>?, arg3: CValuesRef<*>?): Unit {
    memScoped {
        return kniBridge42(arg0?.getPointer(memScope).rawValue, arg1, arg2.rawValue, arg3?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_open(filename: String?, ppDb: CValuesRef<CPointerVar<sqlite3>>?): Int {
    memScoped {
        return kniBridge43(filename?.cstr?.getPointer(memScope).rawValue, ppDb?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_open16(filename: CValuesRef<*>?, ppDb: CValuesRef<CPointerVar<sqlite3>>?): Int {
    memScoped {
        return kniBridge44(filename?.getPointer(memScope).rawValue, ppDb?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_open_v2(filename: String?, ppDb: CValuesRef<CPointerVar<sqlite3>>?, flags: Int, zVfs: String?): Int {
    memScoped {
        return kniBridge45(filename?.cstr?.getPointer(memScope).rawValue, ppDb?.getPointer(memScope).rawValue, flags, zVfs?.cstr?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_uri_parameter(zFilename: String?, zParam: String?): CPointer<ByteVar>? {
    memScoped {
        return interpretCPointer<ByteVar>(kniBridge46(zFilename?.cstr?.getPointer(memScope).rawValue, zParam?.cstr?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_uri_boolean(zFile: String?, zParam: String?, bDefault: Int): Int {
    memScoped {
        return kniBridge47(zFile?.cstr?.getPointer(memScope).rawValue, zParam?.cstr?.getPointer(memScope).rawValue, bDefault)
    }
}

fun sqlite3_uri_int64(arg0: String?, arg1: String?, arg2: sqlite3_int64): sqlite3_int64 {
    memScoped {
        return kniBridge48(arg0?.cstr?.getPointer(memScope).rawValue, arg1?.cstr?.getPointer(memScope).rawValue, arg2)
    }
}

fun sqlite3_errcode(db: CValuesRef<sqlite3>?): Int {
    memScoped {
        return kniBridge49(db?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_extended_errcode(db: CValuesRef<sqlite3>?): Int {
    memScoped {
        return kniBridge50(db?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_errmsg(arg0: CValuesRef<sqlite3>?): CPointer<ByteVar>? {
    memScoped {
        return interpretCPointer<ByteVar>(kniBridge51(arg0?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_errmsg16(arg0: CValuesRef<sqlite3>?): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge52(arg0?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_errstr(arg0: Int): CPointer<ByteVar>? {
    return interpretCPointer<ByteVar>(kniBridge53(arg0))
}

fun sqlite3_limit(arg0: CValuesRef<sqlite3>?, id: Int, newVal: Int): Int {
    memScoped {
        return kniBridge54(arg0?.getPointer(memScope).rawValue, id, newVal)
    }
}

fun sqlite3_prepare(db: CValuesRef<sqlite3>?, zSql: String?, nByte: Int, ppStmt: CValuesRef<CPointerVar<sqlite3_stmt>>?, pzTail: CValuesRef<CPointerVar<ByteVar>>?): Int {
    memScoped {
        return kniBridge55(db?.getPointer(memScope).rawValue, zSql?.cstr?.getPointer(memScope).rawValue, nByte, ppStmt?.getPointer(memScope).rawValue, pzTail?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_prepare_v2(db: CValuesRef<sqlite3>?, zSql: String?, nByte: Int, ppStmt: CValuesRef<CPointerVar<sqlite3_stmt>>?, pzTail: CValuesRef<CPointerVar<ByteVar>>?): Int {
    memScoped {
        return kniBridge56(db?.getPointer(memScope).rawValue, zSql?.cstr?.getPointer(memScope).rawValue, nByte, ppStmt?.getPointer(memScope).rawValue, pzTail?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_prepare16(db: CValuesRef<sqlite3>?, zSql: CValuesRef<*>?, nByte: Int, ppStmt: CValuesRef<CPointerVar<sqlite3_stmt>>?, pzTail: CValuesRef<COpaquePointerVar>?): Int {
    memScoped {
        return kniBridge57(db?.getPointer(memScope).rawValue, zSql?.getPointer(memScope).rawValue, nByte, ppStmt?.getPointer(memScope).rawValue, pzTail?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_prepare16_v2(db: CValuesRef<sqlite3>?, zSql: CValuesRef<*>?, nByte: Int, ppStmt: CValuesRef<CPointerVar<sqlite3_stmt>>?, pzTail: CValuesRef<COpaquePointerVar>?): Int {
    memScoped {
        return kniBridge58(db?.getPointer(memScope).rawValue, zSql?.getPointer(memScope).rawValue, nByte, ppStmt?.getPointer(memScope).rawValue, pzTail?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_sql(pStmt: CValuesRef<sqlite3_stmt>?): CPointer<ByteVar>? {
    memScoped {
        return interpretCPointer<ByteVar>(kniBridge59(pStmt?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_stmt_readonly(pStmt: CValuesRef<sqlite3_stmt>?): Int {
    memScoped {
        return kniBridge60(pStmt?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_stmt_busy(arg0: CValuesRef<sqlite3_stmt>?): Int {
    memScoped {
        return kniBridge61(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_bind_blob(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int, arg2: CValuesRef<*>?, n: Int, arg4: CPointer<CFunction<(COpaquePointer?) -> Unit>>?): Int {
    memScoped {
        return kniBridge62(arg0?.getPointer(memScope).rawValue, arg1, arg2?.getPointer(memScope).rawValue, n, arg4.rawValue)
    }
}

fun sqlite3_bind_blob64(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int, arg2: CValuesRef<*>?, arg3: sqlite3_uint64, arg4: CPointer<CFunction<(COpaquePointer?) -> Unit>>?): Int {
    memScoped {
        return kniBridge63(arg0?.getPointer(memScope).rawValue, arg1, arg2?.getPointer(memScope).rawValue, arg3, arg4.rawValue)
    }
}

fun sqlite3_bind_double(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int, arg2: Double): Int {
    memScoped {
        return kniBridge64(arg0?.getPointer(memScope).rawValue, arg1, arg2)
    }
}

fun sqlite3_bind_int(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int, arg2: Int): Int {
    memScoped {
        return kniBridge65(arg0?.getPointer(memScope).rawValue, arg1, arg2)
    }
}

fun sqlite3_bind_int64(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int, arg2: sqlite3_int64): Int {
    memScoped {
        return kniBridge66(arg0?.getPointer(memScope).rawValue, arg1, arg2)
    }
}

fun sqlite3_bind_null(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int): Int {
    memScoped {
        return kniBridge67(arg0?.getPointer(memScope).rawValue, arg1)
    }
}

fun sqlite3_bind_text(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int, arg2: String?, arg3: Int, arg4: CPointer<CFunction<(COpaquePointer?) -> Unit>>?): Int {
    memScoped {
        return kniBridge68(arg0?.getPointer(memScope).rawValue, arg1, arg2?.cstr?.getPointer(memScope).rawValue, arg3, arg4.rawValue)
    }
}

fun sqlite3_bind_text16(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int, arg2: CValuesRef<*>?, arg3: Int, arg4: CPointer<CFunction<(COpaquePointer?) -> Unit>>?): Int {
    memScoped {
        return kniBridge69(arg0?.getPointer(memScope).rawValue, arg1, arg2?.getPointer(memScope).rawValue, arg3, arg4.rawValue)
    }
}

fun sqlite3_bind_text64(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int, arg2: String?, arg3: sqlite3_uint64, arg4: CPointer<CFunction<(COpaquePointer?) -> Unit>>?, encoding: Byte): Int {
    memScoped {
        return kniBridge70(arg0?.getPointer(memScope).rawValue, arg1, arg2?.cstr?.getPointer(memScope).rawValue, arg3, arg4.rawValue, encoding)
    }
}

fun sqlite3_bind_value(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int, arg2: CValuesRef<sqlite3_value>?): Int {
    memScoped {
        return kniBridge71(arg0?.getPointer(memScope).rawValue, arg1, arg2?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_bind_zeroblob(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int, n: Int): Int {
    memScoped {
        return kniBridge72(arg0?.getPointer(memScope).rawValue, arg1, n)
    }
}

fun sqlite3_bind_zeroblob64(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int, arg2: sqlite3_uint64): Int {
    memScoped {
        return kniBridge73(arg0?.getPointer(memScope).rawValue, arg1, arg2)
    }
}

fun sqlite3_bind_parameter_count(arg0: CValuesRef<sqlite3_stmt>?): Int {
    memScoped {
        return kniBridge74(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_bind_parameter_name(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int): CPointer<ByteVar>? {
    memScoped {
        return interpretCPointer<ByteVar>(kniBridge75(arg0?.getPointer(memScope).rawValue, arg1))
    }
}

fun sqlite3_bind_parameter_index(arg0: CValuesRef<sqlite3_stmt>?, zName: String?): Int {
    memScoped {
        return kniBridge76(arg0?.getPointer(memScope).rawValue, zName?.cstr?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_clear_bindings(arg0: CValuesRef<sqlite3_stmt>?): Int {
    memScoped {
        return kniBridge77(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_column_count(pStmt: CValuesRef<sqlite3_stmt>?): Int {
    memScoped {
        return kniBridge78(pStmt?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_column_name(arg0: CValuesRef<sqlite3_stmt>?, N: Int): CPointer<ByteVar>? {
    memScoped {
        return interpretCPointer<ByteVar>(kniBridge79(arg0?.getPointer(memScope).rawValue, N))
    }
}

fun sqlite3_column_name16(arg0: CValuesRef<sqlite3_stmt>?, N: Int): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge80(arg0?.getPointer(memScope).rawValue, N))
    }
}

fun sqlite3_column_database_name(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int): CPointer<ByteVar>? {
    memScoped {
        return interpretCPointer<ByteVar>(kniBridge81(arg0?.getPointer(memScope).rawValue, arg1))
    }
}

fun sqlite3_column_database_name16(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge82(arg0?.getPointer(memScope).rawValue, arg1))
    }
}

fun sqlite3_column_table_name(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int): CPointer<ByteVar>? {
    memScoped {
        return interpretCPointer<ByteVar>(kniBridge83(arg0?.getPointer(memScope).rawValue, arg1))
    }
}

fun sqlite3_column_table_name16(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge84(arg0?.getPointer(memScope).rawValue, arg1))
    }
}

fun sqlite3_column_origin_name(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int): CPointer<ByteVar>? {
    memScoped {
        return interpretCPointer<ByteVar>(kniBridge85(arg0?.getPointer(memScope).rawValue, arg1))
    }
}

fun sqlite3_column_origin_name16(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge86(arg0?.getPointer(memScope).rawValue, arg1))
    }
}

fun sqlite3_column_decltype(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int): CPointer<ByteVar>? {
    memScoped {
        return interpretCPointer<ByteVar>(kniBridge87(arg0?.getPointer(memScope).rawValue, arg1))
    }
}

fun sqlite3_column_decltype16(arg0: CValuesRef<sqlite3_stmt>?, arg1: Int): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge88(arg0?.getPointer(memScope).rawValue, arg1))
    }
}

fun sqlite3_step(arg0: CValuesRef<sqlite3_stmt>?): Int {
    memScoped {
        return kniBridge89(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_data_count(pStmt: CValuesRef<sqlite3_stmt>?): Int {
    memScoped {
        return kniBridge90(pStmt?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_column_blob(arg0: CValuesRef<sqlite3_stmt>?, iCol: Int): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge91(arg0?.getPointer(memScope).rawValue, iCol))
    }
}

fun sqlite3_column_bytes(arg0: CValuesRef<sqlite3_stmt>?, iCol: Int): Int {
    memScoped {
        return kniBridge92(arg0?.getPointer(memScope).rawValue, iCol)
    }
}

fun sqlite3_column_bytes16(arg0: CValuesRef<sqlite3_stmt>?, iCol: Int): Int {
    memScoped {
        return kniBridge93(arg0?.getPointer(memScope).rawValue, iCol)
    }
}

fun sqlite3_column_double(arg0: CValuesRef<sqlite3_stmt>?, iCol: Int): Double {
    memScoped {
        return kniBridge94(arg0?.getPointer(memScope).rawValue, iCol)
    }
}

fun sqlite3_column_int(arg0: CValuesRef<sqlite3_stmt>?, iCol: Int): Int {
    memScoped {
        return kniBridge95(arg0?.getPointer(memScope).rawValue, iCol)
    }
}

fun sqlite3_column_int64(arg0: CValuesRef<sqlite3_stmt>?, iCol: Int): sqlite3_int64 {
    memScoped {
        return kniBridge96(arg0?.getPointer(memScope).rawValue, iCol)
    }
}

fun sqlite3_column_text(arg0: CValuesRef<sqlite3_stmt>?, iCol: Int): CPointer<ByteVar>? {
    memScoped {
        return interpretCPointer<ByteVar>(kniBridge97(arg0?.getPointer(memScope).rawValue, iCol))
    }
}

fun sqlite3_column_text16(arg0: CValuesRef<sqlite3_stmt>?, iCol: Int): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge98(arg0?.getPointer(memScope).rawValue, iCol))
    }
}

fun sqlite3_column_type(arg0: CValuesRef<sqlite3_stmt>?, iCol: Int): Int {
    memScoped {
        return kniBridge99(arg0?.getPointer(memScope).rawValue, iCol)
    }
}

fun sqlite3_column_value(arg0: CValuesRef<sqlite3_stmt>?, iCol: Int): CPointer<sqlite3_value>? {
    memScoped {
        return interpretCPointer<sqlite3_value>(kniBridge100(arg0?.getPointer(memScope).rawValue, iCol))
    }
}

fun sqlite3_finalize(pStmt: CValuesRef<sqlite3_stmt>?): Int {
    memScoped {
        return kniBridge101(pStmt?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_reset(pStmt: CValuesRef<sqlite3_stmt>?): Int {
    memScoped {
        return kniBridge102(pStmt?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_create_function(db: CValuesRef<sqlite3>?, zFunctionName: String?, nArg: Int, eTextRep: Int, pApp: CValuesRef<*>?, xFunc: CPointer<CFunction<(CPointer<sqlite3_context>?, Int, CPointer<CPointerVar<sqlite3_value>>?) -> Unit>>?, xStep: CPointer<CFunction<(CPointer<sqlite3_context>?, Int, CPointer<CPointerVar<sqlite3_value>>?) -> Unit>>?, xFinal: CPointer<CFunction<(CPointer<sqlite3_context>?) -> Unit>>?): Int {
    memScoped {
        return kniBridge103(db?.getPointer(memScope).rawValue, zFunctionName?.cstr?.getPointer(memScope).rawValue, nArg, eTextRep, pApp?.getPointer(memScope).rawValue, xFunc.rawValue, xStep.rawValue, xFinal.rawValue)
    }
}

fun sqlite3_create_function16(db: CValuesRef<sqlite3>?, zFunctionName: CValuesRef<*>?, nArg: Int, eTextRep: Int, pApp: CValuesRef<*>?, xFunc: CPointer<CFunction<(CPointer<sqlite3_context>?, Int, CPointer<CPointerVar<sqlite3_value>>?) -> Unit>>?, xStep: CPointer<CFunction<(CPointer<sqlite3_context>?, Int, CPointer<CPointerVar<sqlite3_value>>?) -> Unit>>?, xFinal: CPointer<CFunction<(CPointer<sqlite3_context>?) -> Unit>>?): Int {
    memScoped {
        return kniBridge104(db?.getPointer(memScope).rawValue, zFunctionName?.getPointer(memScope).rawValue, nArg, eTextRep, pApp?.getPointer(memScope).rawValue, xFunc.rawValue, xStep.rawValue, xFinal.rawValue)
    }
}

fun sqlite3_create_function_v2(db: CValuesRef<sqlite3>?, zFunctionName: String?, nArg: Int, eTextRep: Int, pApp: CValuesRef<*>?, xFunc: CPointer<CFunction<(CPointer<sqlite3_context>?, Int, CPointer<CPointerVar<sqlite3_value>>?) -> Unit>>?, xStep: CPointer<CFunction<(CPointer<sqlite3_context>?, Int, CPointer<CPointerVar<sqlite3_value>>?) -> Unit>>?, xFinal: CPointer<CFunction<(CPointer<sqlite3_context>?) -> Unit>>?, xDestroy: CPointer<CFunction<(COpaquePointer?) -> Unit>>?): Int {
    memScoped {
        return kniBridge105(db?.getPointer(memScope).rawValue, zFunctionName?.cstr?.getPointer(memScope).rawValue, nArg, eTextRep, pApp?.getPointer(memScope).rawValue, xFunc.rawValue, xStep.rawValue, xFinal.rawValue, xDestroy.rawValue)
    }
}

fun sqlite3_aggregate_count(arg0: CValuesRef<sqlite3_context>?): Int {
    memScoped {
        return kniBridge106(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_expired(arg0: CValuesRef<sqlite3_stmt>?): Int {
    memScoped {
        return kniBridge107(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_transfer_bindings(arg0: CValuesRef<sqlite3_stmt>?, arg1: CValuesRef<sqlite3_stmt>?): Int {
    memScoped {
        return kniBridge108(arg0?.getPointer(memScope).rawValue, arg1?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_global_recover(): Int {
    return kniBridge109()
}

fun sqlite3_thread_cleanup(): Unit {
    return kniBridge110()
}

fun sqlite3_memory_alarm(arg0: CPointer<CFunction<(COpaquePointer?, sqlite3_int64, Int) -> Unit>>?, arg1: CValuesRef<*>?, arg2: sqlite3_int64): Int {
    memScoped {
        return kniBridge111(arg0.rawValue, arg1?.getPointer(memScope).rawValue, arg2)
    }
}

fun sqlite3_value_blob(arg0: CValuesRef<sqlite3_value>?): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge112(arg0?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_value_bytes(arg0: CValuesRef<sqlite3_value>?): Int {
    memScoped {
        return kniBridge113(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_value_bytes16(arg0: CValuesRef<sqlite3_value>?): Int {
    memScoped {
        return kniBridge114(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_value_double(arg0: CValuesRef<sqlite3_value>?): Double {
    memScoped {
        return kniBridge115(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_value_int(arg0: CValuesRef<sqlite3_value>?): Int {
    memScoped {
        return kniBridge116(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_value_int64(arg0: CValuesRef<sqlite3_value>?): sqlite3_int64 {
    memScoped {
        return kniBridge117(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_value_text(arg0: CValuesRef<sqlite3_value>?): CPointer<ByteVar>? {
    memScoped {
        return interpretCPointer<ByteVar>(kniBridge118(arg0?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_value_text16(arg0: CValuesRef<sqlite3_value>?): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge119(arg0?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_value_text16le(arg0: CValuesRef<sqlite3_value>?): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge120(arg0?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_value_text16be(arg0: CValuesRef<sqlite3_value>?): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge121(arg0?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_value_type(arg0: CValuesRef<sqlite3_value>?): Int {
    memScoped {
        return kniBridge122(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_value_numeric_type(arg0: CValuesRef<sqlite3_value>?): Int {
    memScoped {
        return kniBridge123(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_value_subtype(arg0: CValuesRef<sqlite3_value>?): Int {
    memScoped {
        return kniBridge124(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_value_dup(arg0: CValuesRef<sqlite3_value>?): CPointer<sqlite3_value>? {
    memScoped {
        return interpretCPointer<sqlite3_value>(kniBridge125(arg0?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_value_free(arg0: CValuesRef<sqlite3_value>?): Unit {
    memScoped {
        return kniBridge126(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_aggregate_context(arg0: CValuesRef<sqlite3_context>?, nBytes: Int): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge127(arg0?.getPointer(memScope).rawValue, nBytes))
    }
}

fun sqlite3_user_data(arg0: CValuesRef<sqlite3_context>?): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge128(arg0?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_context_db_handle(arg0: CValuesRef<sqlite3_context>?): CPointer<sqlite3>? {
    memScoped {
        return interpretCPointer<sqlite3>(kniBridge129(arg0?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_get_auxdata(arg0: CValuesRef<sqlite3_context>?, N: Int): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge130(arg0?.getPointer(memScope).rawValue, N))
    }
}

fun sqlite3_set_auxdata(arg0: CValuesRef<sqlite3_context>?, N: Int, arg2: CValuesRef<*>?, arg3: CPointer<CFunction<(COpaquePointer?) -> Unit>>?): Unit {
    memScoped {
        return kniBridge131(arg0?.getPointer(memScope).rawValue, N, arg2?.getPointer(memScope).rawValue, arg3.rawValue)
    }
}

fun sqlite3_result_blob(arg0: CValuesRef<sqlite3_context>?, arg1: CValuesRef<*>?, arg2: Int, arg3: CPointer<CFunction<(COpaquePointer?) -> Unit>>?): Unit {
    memScoped {
        return kniBridge132(arg0?.getPointer(memScope).rawValue, arg1?.getPointer(memScope).rawValue, arg2, arg3.rawValue)
    }
}

fun sqlite3_result_blob64(arg0: CValuesRef<sqlite3_context>?, arg1: CValuesRef<*>?, arg2: sqlite3_uint64, arg3: CPointer<CFunction<(COpaquePointer?) -> Unit>>?): Unit {
    memScoped {
        return kniBridge133(arg0?.getPointer(memScope).rawValue, arg1?.getPointer(memScope).rawValue, arg2, arg3.rawValue)
    }
}

fun sqlite3_result_double(arg0: CValuesRef<sqlite3_context>?, arg1: Double): Unit {
    memScoped {
        return kniBridge134(arg0?.getPointer(memScope).rawValue, arg1)
    }
}

fun sqlite3_result_error(arg0: CValuesRef<sqlite3_context>?, arg1: String?, arg2: Int): Unit {
    memScoped {
        return kniBridge135(arg0?.getPointer(memScope).rawValue, arg1?.cstr?.getPointer(memScope).rawValue, arg2)
    }
}

fun sqlite3_result_error16(arg0: CValuesRef<sqlite3_context>?, arg1: CValuesRef<*>?, arg2: Int): Unit {
    memScoped {
        return kniBridge136(arg0?.getPointer(memScope).rawValue, arg1?.getPointer(memScope).rawValue, arg2)
    }
}

fun sqlite3_result_error_toobig(arg0: CValuesRef<sqlite3_context>?): Unit {
    memScoped {
        return kniBridge137(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_result_error_nomem(arg0: CValuesRef<sqlite3_context>?): Unit {
    memScoped {
        return kniBridge138(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_result_error_code(arg0: CValuesRef<sqlite3_context>?, arg1: Int): Unit {
    memScoped {
        return kniBridge139(arg0?.getPointer(memScope).rawValue, arg1)
    }
}

fun sqlite3_result_int(arg0: CValuesRef<sqlite3_context>?, arg1: Int): Unit {
    memScoped {
        return kniBridge140(arg0?.getPointer(memScope).rawValue, arg1)
    }
}

fun sqlite3_result_int64(arg0: CValuesRef<sqlite3_context>?, arg1: sqlite3_int64): Unit {
    memScoped {
        return kniBridge141(arg0?.getPointer(memScope).rawValue, arg1)
    }
}

fun sqlite3_result_null(arg0: CValuesRef<sqlite3_context>?): Unit {
    memScoped {
        return kniBridge142(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_result_text(arg0: CValuesRef<sqlite3_context>?, arg1: String?, arg2: Int, arg3: CPointer<CFunction<(COpaquePointer?) -> Unit>>?): Unit {
    memScoped {
        return kniBridge143(arg0?.getPointer(memScope).rawValue, arg1?.cstr?.getPointer(memScope).rawValue, arg2, arg3.rawValue)
    }
}

fun sqlite3_result_text64(arg0: CValuesRef<sqlite3_context>?, arg1: String?, arg2: sqlite3_uint64, arg3: CPointer<CFunction<(COpaquePointer?) -> Unit>>?, encoding: Byte): Unit {
    memScoped {
        return kniBridge144(arg0?.getPointer(memScope).rawValue, arg1?.cstr?.getPointer(memScope).rawValue, arg2, arg3.rawValue, encoding)
    }
}

fun sqlite3_result_text16(arg0: CValuesRef<sqlite3_context>?, arg1: CValuesRef<*>?, arg2: Int, arg3: CPointer<CFunction<(COpaquePointer?) -> Unit>>?): Unit {
    memScoped {
        return kniBridge145(arg0?.getPointer(memScope).rawValue, arg1?.getPointer(memScope).rawValue, arg2, arg3.rawValue)
    }
}

fun sqlite3_result_text16le(arg0: CValuesRef<sqlite3_context>?, arg1: CValuesRef<*>?, arg2: Int, arg3: CPointer<CFunction<(COpaquePointer?) -> Unit>>?): Unit {
    memScoped {
        return kniBridge146(arg0?.getPointer(memScope).rawValue, arg1?.getPointer(memScope).rawValue, arg2, arg3.rawValue)
    }
}

fun sqlite3_result_text16be(arg0: CValuesRef<sqlite3_context>?, arg1: CValuesRef<*>?, arg2: Int, arg3: CPointer<CFunction<(COpaquePointer?) -> Unit>>?): Unit {
    memScoped {
        return kniBridge147(arg0?.getPointer(memScope).rawValue, arg1?.getPointer(memScope).rawValue, arg2, arg3.rawValue)
    }
}

fun sqlite3_result_value(arg0: CValuesRef<sqlite3_context>?, arg1: CValuesRef<sqlite3_value>?): Unit {
    memScoped {
        return kniBridge148(arg0?.getPointer(memScope).rawValue, arg1?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_result_zeroblob(arg0: CValuesRef<sqlite3_context>?, n: Int): Unit {
    memScoped {
        return kniBridge149(arg0?.getPointer(memScope).rawValue, n)
    }
}

fun sqlite3_result_zeroblob64(arg0: CValuesRef<sqlite3_context>?, n: sqlite3_uint64): Int {
    memScoped {
        return kniBridge150(arg0?.getPointer(memScope).rawValue, n)
    }
}

fun sqlite3_result_subtype(arg0: CValuesRef<sqlite3_context>?, arg1: Int): Unit {
    memScoped {
        return kniBridge151(arg0?.getPointer(memScope).rawValue, arg1)
    }
}

fun sqlite3_create_collation(arg0: CValuesRef<sqlite3>?, zName: String?, eTextRep: Int, pArg: CValuesRef<*>?, xCompare: CPointer<CFunction<(COpaquePointer?, Int, COpaquePointer?, Int, COpaquePointer?) -> Int>>?): Int {
    memScoped {
        return kniBridge152(arg0?.getPointer(memScope).rawValue, zName?.cstr?.getPointer(memScope).rawValue, eTextRep, pArg?.getPointer(memScope).rawValue, xCompare.rawValue)
    }
}

fun sqlite3_create_collation_v2(arg0: CValuesRef<sqlite3>?, zName: String?, eTextRep: Int, pArg: CValuesRef<*>?, xCompare: CPointer<CFunction<(COpaquePointer?, Int, COpaquePointer?, Int, COpaquePointer?) -> Int>>?, xDestroy: CPointer<CFunction<(COpaquePointer?) -> Unit>>?): Int {
    memScoped {
        return kniBridge153(arg0?.getPointer(memScope).rawValue, zName?.cstr?.getPointer(memScope).rawValue, eTextRep, pArg?.getPointer(memScope).rawValue, xCompare.rawValue, xDestroy.rawValue)
    }
}

fun sqlite3_create_collation16(arg0: CValuesRef<sqlite3>?, zName: CValuesRef<*>?, eTextRep: Int, pArg: CValuesRef<*>?, xCompare: CPointer<CFunction<(COpaquePointer?, Int, COpaquePointer?, Int, COpaquePointer?) -> Int>>?): Int {
    memScoped {
        return kniBridge154(arg0?.getPointer(memScope).rawValue, zName?.getPointer(memScope).rawValue, eTextRep, pArg?.getPointer(memScope).rawValue, xCompare.rawValue)
    }
}

fun sqlite3_collation_needed(arg0: CValuesRef<sqlite3>?, arg1: CValuesRef<*>?, arg2: CPointer<CFunction<(COpaquePointer?, CPointer<sqlite3>?, Int, CPointer<ByteVar>?) -> Unit>>?): Int {
    memScoped {
        return kniBridge155(arg0?.getPointer(memScope).rawValue, arg1?.getPointer(memScope).rawValue, arg2.rawValue)
    }
}

fun sqlite3_collation_needed16(arg0: CValuesRef<sqlite3>?, arg1: CValuesRef<*>?, arg2: CPointer<CFunction<(COpaquePointer?, CPointer<sqlite3>?, Int, COpaquePointer?) -> Unit>>?): Int {
    memScoped {
        return kniBridge156(arg0?.getPointer(memScope).rawValue, arg1?.getPointer(memScope).rawValue, arg2.rawValue)
    }
}

fun sqlite3_sleep(arg0: Int): Int {
    return kniBridge157(arg0)
}

fun sqlite3_get_autocommit(arg0: CValuesRef<sqlite3>?): Int {
    memScoped {
        return kniBridge158(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_db_handle(arg0: CValuesRef<sqlite3_stmt>?): CPointer<sqlite3>? {
    memScoped {
        return interpretCPointer<sqlite3>(kniBridge159(arg0?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_db_filename(db: CValuesRef<sqlite3>?, zDbName: String?): CPointer<ByteVar>? {
    memScoped {
        return interpretCPointer<ByteVar>(kniBridge160(db?.getPointer(memScope).rawValue, zDbName?.cstr?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_db_readonly(db: CValuesRef<sqlite3>?, zDbName: String?): Int {
    memScoped {
        return kniBridge161(db?.getPointer(memScope).rawValue, zDbName?.cstr?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_next_stmt(pDb: CValuesRef<sqlite3>?, pStmt: CValuesRef<sqlite3_stmt>?): CPointer<sqlite3_stmt>? {
    memScoped {
        return interpretCPointer<sqlite3_stmt>(kniBridge162(pDb?.getPointer(memScope).rawValue, pStmt?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_commit_hook(arg0: CValuesRef<sqlite3>?, arg1: CPointer<CFunction<(COpaquePointer?) -> Int>>?, arg2: CValuesRef<*>?): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge163(arg0?.getPointer(memScope).rawValue, arg1.rawValue, arg2?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_rollback_hook(arg0: CValuesRef<sqlite3>?, arg1: CPointer<CFunction<(COpaquePointer?) -> Unit>>?, arg2: CValuesRef<*>?): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge164(arg0?.getPointer(memScope).rawValue, arg1.rawValue, arg2?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_update_hook(arg0: CValuesRef<sqlite3>?, arg1: CPointer<CFunction<(COpaquePointer?, Int, CPointer<ByteVar>?, CPointer<ByteVar>?, sqlite3_int64) -> Unit>>?, arg2: CValuesRef<*>?): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge165(arg0?.getPointer(memScope).rawValue, arg1.rawValue, arg2?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_enable_shared_cache(arg0: Int): Int {
    return kniBridge166(arg0)
}

fun sqlite3_release_memory(arg0: Int): Int {
    return kniBridge167(arg0)
}

fun sqlite3_db_release_memory(arg0: CValuesRef<sqlite3>?): Int {
    memScoped {
        return kniBridge168(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_soft_heap_limit64(N: sqlite3_int64): sqlite3_int64 {
    return kniBridge169(N)
}

fun sqlite3_soft_heap_limit(N: Int): Unit {
    return kniBridge170(N)
}

fun sqlite3_table_column_metadata(db: CValuesRef<sqlite3>?, zDbName: String?, zTableName: String?, zColumnName: String?, pzDataType: CValuesRef<CPointerVar<ByteVar>>?, pzCollSeq: CValuesRef<CPointerVar<ByteVar>>?, pNotNull: CValuesRef<IntVar>?, pPrimaryKey: CValuesRef<IntVar>?, pAutoinc: CValuesRef<IntVar>?): Int {
    memScoped {
        return kniBridge171(db?.getPointer(memScope).rawValue, zDbName?.cstr?.getPointer(memScope).rawValue, zTableName?.cstr?.getPointer(memScope).rawValue, zColumnName?.cstr?.getPointer(memScope).rawValue, pzDataType?.getPointer(memScope).rawValue, pzCollSeq?.getPointer(memScope).rawValue, pNotNull?.getPointer(memScope).rawValue, pPrimaryKey?.getPointer(memScope).rawValue, pAutoinc?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_load_extension(db: CValuesRef<sqlite3>?, zFile: String?, zProc: String?, pzErrMsg: CValuesRef<CPointerVar<ByteVar>>?): Int {
    memScoped {
        return kniBridge172(db?.getPointer(memScope).rawValue, zFile?.cstr?.getPointer(memScope).rawValue, zProc?.cstr?.getPointer(memScope).rawValue, pzErrMsg?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_enable_load_extension(db: CValuesRef<sqlite3>?, onoff: Int): Int {
    memScoped {
        return kniBridge173(db?.getPointer(memScope).rawValue, onoff)
    }
}

fun sqlite3_auto_extension(xEntryPoint: CPointer<CFunction<() -> Unit>>?): Int {
    return kniBridge174(xEntryPoint.rawValue)
}

fun sqlite3_cancel_auto_extension(xEntryPoint: CPointer<CFunction<() -> Unit>>?): Int {
    return kniBridge175(xEntryPoint.rawValue)
}

fun sqlite3_reset_auto_extension(): Unit {
    return kniBridge176()
}

fun sqlite3_create_module(db: CValuesRef<sqlite3>?, zName: String?, p: CValuesRef<sqlite3_module>?, pClientData: CValuesRef<*>?): Int {
    memScoped {
        return kniBridge177(db?.getPointer(memScope).rawValue, zName?.cstr?.getPointer(memScope).rawValue, p?.getPointer(memScope).rawValue, pClientData?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_create_module_v2(db: CValuesRef<sqlite3>?, zName: String?, p: CValuesRef<sqlite3_module>?, pClientData: CValuesRef<*>?, xDestroy: CPointer<CFunction<(COpaquePointer?) -> Unit>>?): Int {
    memScoped {
        return kniBridge178(db?.getPointer(memScope).rawValue, zName?.cstr?.getPointer(memScope).rawValue, p?.getPointer(memScope).rawValue, pClientData?.getPointer(memScope).rawValue, xDestroy.rawValue)
    }
}

fun sqlite3_declare_vtab(arg0: CValuesRef<sqlite3>?, zSQL: String?): Int {
    memScoped {
        return kniBridge179(arg0?.getPointer(memScope).rawValue, zSQL?.cstr?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_overload_function(arg0: CValuesRef<sqlite3>?, zFuncName: String?, nArg: Int): Int {
    memScoped {
        return kniBridge180(arg0?.getPointer(memScope).rawValue, zFuncName?.cstr?.getPointer(memScope).rawValue, nArg)
    }
}

fun sqlite3_blob_open(arg0: CValuesRef<sqlite3>?, zDb: String?, zTable: String?, zColumn: String?, iRow: sqlite3_int64, flags: Int, ppBlob: CValuesRef<CPointerVar<sqlite3_blob>>?): Int {
    memScoped {
        return kniBridge181(arg0?.getPointer(memScope).rawValue, zDb?.cstr?.getPointer(memScope).rawValue, zTable?.cstr?.getPointer(memScope).rawValue, zColumn?.cstr?.getPointer(memScope).rawValue, iRow, flags, ppBlob?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_blob_reopen(arg0: CValuesRef<sqlite3_blob>?, arg1: sqlite3_int64): Int {
    memScoped {
        return kniBridge182(arg0?.getPointer(memScope).rawValue, arg1)
    }
}

fun sqlite3_blob_close(arg0: CValuesRef<sqlite3_blob>?): Int {
    memScoped {
        return kniBridge183(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_blob_bytes(arg0: CValuesRef<sqlite3_blob>?): Int {
    memScoped {
        return kniBridge184(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_blob_read(arg0: CValuesRef<sqlite3_blob>?, Z: CValuesRef<*>?, N: Int, iOffset: Int): Int {
    memScoped {
        return kniBridge185(arg0?.getPointer(memScope).rawValue, Z?.getPointer(memScope).rawValue, N, iOffset)
    }
}

fun sqlite3_blob_write(arg0: CValuesRef<sqlite3_blob>?, z: CValuesRef<*>?, n: Int, iOffset: Int): Int {
    memScoped {
        return kniBridge186(arg0?.getPointer(memScope).rawValue, z?.getPointer(memScope).rawValue, n, iOffset)
    }
}

fun sqlite3_vfs_find(zVfsName: String?): CPointer<sqlite3_vfs>? {
    memScoped {
        return interpretCPointer<sqlite3_vfs>(kniBridge187(zVfsName?.cstr?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_vfs_register(arg0: CValuesRef<sqlite3_vfs>?, makeDflt: Int): Int {
    memScoped {
        return kniBridge188(arg0?.getPointer(memScope).rawValue, makeDflt)
    }
}

fun sqlite3_vfs_unregister(arg0: CValuesRef<sqlite3_vfs>?): Int {
    memScoped {
        return kniBridge189(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_mutex_alloc(arg0: Int): CPointer<sqlite3_mutex>? {
    return interpretCPointer<sqlite3_mutex>(kniBridge190(arg0))
}

fun sqlite3_mutex_free(arg0: CValuesRef<sqlite3_mutex>?): Unit {
    memScoped {
        return kniBridge191(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_mutex_enter(arg0: CValuesRef<sqlite3_mutex>?): Unit {
    memScoped {
        return kniBridge192(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_mutex_try(arg0: CValuesRef<sqlite3_mutex>?): Int {
    memScoped {
        return kniBridge193(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_mutex_leave(arg0: CValuesRef<sqlite3_mutex>?): Unit {
    memScoped {
        return kniBridge194(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_mutex_held(arg0: CValuesRef<sqlite3_mutex>?): Int {
    memScoped {
        return kniBridge195(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_mutex_notheld(arg0: CValuesRef<sqlite3_mutex>?): Int {
    memScoped {
        return kniBridge196(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_db_mutex(arg0: CValuesRef<sqlite3>?): CPointer<sqlite3_mutex>? {
    memScoped {
        return interpretCPointer<sqlite3_mutex>(kniBridge197(arg0?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_file_control(arg0: CValuesRef<sqlite3>?, zDbName: String?, op: Int, arg3: CValuesRef<*>?): Int {
    memScoped {
        return kniBridge198(arg0?.getPointer(memScope).rawValue, zDbName?.cstr?.getPointer(memScope).rawValue, op, arg3?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_test_control(op: Int, vararg variadicArguments: Any?): Int {
    memScoped {
        val kniResult = allocFfiReturnValueBuffer<IntVar>(typeOf<IntVar>())
        callWithVarargs(kniBridge199(), kniResult.rawPtr, FFI_TYPE_KIND_SINT32, arrayOf(op), variadicArguments, memScope)
        return kniResult.value
    }
}

fun sqlite3_status(op: Int, pCurrent: CValuesRef<IntVar>?, pHighwater: CValuesRef<IntVar>?, resetFlag: Int): Int {
    memScoped {
        return kniBridge200(op, pCurrent?.getPointer(memScope).rawValue, pHighwater?.getPointer(memScope).rawValue, resetFlag)
    }
}

fun sqlite3_status64(op: Int, pCurrent: CValuesRef<sqlite3_int64Var>?, pHighwater: CValuesRef<sqlite3_int64Var>?, resetFlag: Int): Int {
    memScoped {
        return kniBridge201(op, pCurrent?.getPointer(memScope).rawValue, pHighwater?.getPointer(memScope).rawValue, resetFlag)
    }
}

fun sqlite3_db_status(arg0: CValuesRef<sqlite3>?, op: Int, pCur: CValuesRef<IntVar>?, pHiwtr: CValuesRef<IntVar>?, resetFlg: Int): Int {
    memScoped {
        return kniBridge202(arg0?.getPointer(memScope).rawValue, op, pCur?.getPointer(memScope).rawValue, pHiwtr?.getPointer(memScope).rawValue, resetFlg)
    }
}

fun sqlite3_stmt_status(arg0: CValuesRef<sqlite3_stmt>?, op: Int, resetFlg: Int): Int {
    memScoped {
        return kniBridge203(arg0?.getPointer(memScope).rawValue, op, resetFlg)
    }
}

fun sqlite3_backup_init(pDest: CValuesRef<sqlite3>?, zDestName: String?, pSource: CValuesRef<sqlite3>?, zSourceName: String?): CPointer<sqlite3_backup>? {
    memScoped {
        return interpretCPointer<sqlite3_backup>(kniBridge204(pDest?.getPointer(memScope).rawValue, zDestName?.cstr?.getPointer(memScope).rawValue, pSource?.getPointer(memScope).rawValue, zSourceName?.cstr?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_backup_step(p: CValuesRef<sqlite3_backup>?, nPage: Int): Int {
    memScoped {
        return kniBridge205(p?.getPointer(memScope).rawValue, nPage)
    }
}

fun sqlite3_backup_finish(p: CValuesRef<sqlite3_backup>?): Int {
    memScoped {
        return kniBridge206(p?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_backup_remaining(p: CValuesRef<sqlite3_backup>?): Int {
    memScoped {
        return kniBridge207(p?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_backup_pagecount(p: CValuesRef<sqlite3_backup>?): Int {
    memScoped {
        return kniBridge208(p?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_unlock_notify(pBlocked: CValuesRef<sqlite3>?, xNotify: CPointer<CFunction<(CPointer<COpaquePointerVar>?, Int) -> Unit>>?, pNotifyArg: CValuesRef<*>?): Int {
    memScoped {
        return kniBridge209(pBlocked?.getPointer(memScope).rawValue, xNotify.rawValue, pNotifyArg?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_stricmp(arg0: String?, arg1: String?): Int {
    memScoped {
        return kniBridge210(arg0?.cstr?.getPointer(memScope).rawValue, arg1?.cstr?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_strnicmp(arg0: String?, arg1: String?, arg2: Int): Int {
    memScoped {
        return kniBridge211(arg0?.cstr?.getPointer(memScope).rawValue, arg1?.cstr?.getPointer(memScope).rawValue, arg2)
    }
}

fun sqlite3_strglob(zGlob: String?, zStr: String?): Int {
    memScoped {
        return kniBridge212(zGlob?.cstr?.getPointer(memScope).rawValue, zStr?.cstr?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_strlike(zGlob: String?, zStr: String?, cEsc: Int): Int {
    memScoped {
        return kniBridge213(zGlob?.cstr?.getPointer(memScope).rawValue, zStr?.cstr?.getPointer(memScope).rawValue, cEsc)
    }
}

fun sqlite3_log(iErrCode: Int, zFormat: String?, vararg variadicArguments: Any?): Unit {
    memScoped {
        callWithVarargs(kniBridge214(), nativeNullPtr, FFI_TYPE_KIND_VOID, arrayOf(iErrCode, zFormat?.cstr?.getPointer(memScope)), variadicArguments, memScope)
    }
}

fun sqlite3_wal_hook(arg0: CValuesRef<sqlite3>?, arg1: CPointer<CFunction<(COpaquePointer?, CPointer<sqlite3>?, CPointer<ByteVar>?, Int) -> Int>>?, arg2: CValuesRef<*>?): COpaquePointer? {
    memScoped {
        return interpretCPointer<COpaque>(kniBridge215(arg0?.getPointer(memScope).rawValue, arg1.rawValue, arg2?.getPointer(memScope).rawValue))
    }
}

fun sqlite3_wal_autocheckpoint(db: CValuesRef<sqlite3>?, N: Int): Int {
    memScoped {
        return kniBridge216(db?.getPointer(memScope).rawValue, N)
    }
}

fun sqlite3_wal_checkpoint(db: CValuesRef<sqlite3>?, zDb: String?): Int {
    memScoped {
        return kniBridge217(db?.getPointer(memScope).rawValue, zDb?.cstr?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_wal_checkpoint_v2(db: CValuesRef<sqlite3>?, zDb: String?, eMode: Int, pnLog: CValuesRef<IntVar>?, pnCkpt: CValuesRef<IntVar>?): Int {
    memScoped {
        return kniBridge218(db?.getPointer(memScope).rawValue, zDb?.cstr?.getPointer(memScope).rawValue, eMode, pnLog?.getPointer(memScope).rawValue, pnCkpt?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_vtab_config(arg0: CValuesRef<sqlite3>?, op: Int, vararg variadicArguments: Any?): Int {
    memScoped {
        val kniResult = allocFfiReturnValueBuffer<IntVar>(typeOf<IntVar>())
        callWithVarargs(kniBridge219(), kniResult.rawPtr, FFI_TYPE_KIND_SINT32, arrayOf(arg0?.getPointer(memScope), op), variadicArguments, memScope)
        return kniResult.value
    }
}

fun sqlite3_vtab_on_conflict(arg0: CValuesRef<sqlite3>?): Int {
    memScoped {
        return kniBridge220(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_stmt_scanstatus(pStmt: CValuesRef<sqlite3_stmt>?, idx: Int, iScanStatusOp: Int, pOut: CValuesRef<*>?): Int {
    memScoped {
        return kniBridge221(pStmt?.getPointer(memScope).rawValue, idx, iScanStatusOp, pOut?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_stmt_scanstatus_reset(arg0: CValuesRef<sqlite3_stmt>?): Unit {
    memScoped {
        return kniBridge222(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_db_cacheflush(arg0: CValuesRef<sqlite3>?): Int {
    memScoped {
        return kniBridge223(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_snapshot_get(db: CValuesRef<sqlite3>?, zSchema: String?, ppSnapshot: CValuesRef<CPointerVar<sqlite3_snapshot>>?): Int {
    memScoped {
        return kniBridge224(db?.getPointer(memScope).rawValue, zSchema?.cstr?.getPointer(memScope).rawValue, ppSnapshot?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_snapshot_open(db: CValuesRef<sqlite3>?, zSchema: String?, pSnapshot: CValuesRef<sqlite3_snapshot>?): Int {
    memScoped {
        return kniBridge225(db?.getPointer(memScope).rawValue, zSchema?.cstr?.getPointer(memScope).rawValue, pSnapshot?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_snapshot_free(arg0: CValuesRef<sqlite3_snapshot>?): Unit {
    memScoped {
        return kniBridge226(arg0?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_rtree_geometry_callback(db: CValuesRef<sqlite3>?, zGeom: String?, xGeom: CPointer<CFunction<(CPointer<sqlite3_rtree_geometry>?, Int, CPointer<sqlite3_rtree_dblVar>?, CPointer<IntVar>?) -> Int>>?, pContext: CValuesRef<*>?): Int {
    memScoped {
        return kniBridge227(db?.getPointer(memScope).rawValue, zGeom?.cstr?.getPointer(memScope).rawValue, xGeom.rawValue, pContext?.getPointer(memScope).rawValue)
    }
}

fun sqlite3_rtree_query_callback(db: CValuesRef<sqlite3>?, zQueryFunc: String?, xQueryFunc: CPointer<CFunction<(CPointer<sqlite3_rtree_query_info>?) -> Int>>?, pContext: CValuesRef<*>?, xDestructor: CPointer<CFunction<(COpaquePointer?) -> Unit>>?): Int {
    memScoped {
        return kniBridge228(db?.getPointer(memScope).rawValue, zQueryFunc?.cstr?.getPointer(memScope).rawValue, xQueryFunc.rawValue, pContext?.getPointer(memScope).rawValue, xDestructor.rawValue)
    }
}

val __GNUC_VA_LIST: Int = 1

val SQLITE_VERSION_NUMBER: Int = 3011000

val SQLITE_OK: Int = 0

val SQLITE_ERROR: Int = 1

val SQLITE_INTERNAL: Int = 2

val SQLITE_PERM: Int = 3

val SQLITE_ABORT: Int = 4

val SQLITE_BUSY: Int = 5

val SQLITE_LOCKED: Int = 6

val SQLITE_NOMEM: Int = 7

val SQLITE_READONLY: Int = 8

val SQLITE_INTERRUPT: Int = 9

val SQLITE_IOERR: Int = 10

val SQLITE_CORRUPT: Int = 11

val SQLITE_NOTFOUND: Int = 12

val SQLITE_FULL: Int = 13

val SQLITE_CANTOPEN: Int = 14

val SQLITE_PROTOCOL: Int = 15

val SQLITE_EMPTY: Int = 16

val SQLITE_SCHEMA: Int = 17

val SQLITE_TOOBIG: Int = 18

val SQLITE_CONSTRAINT: Int = 19

val SQLITE_MISMATCH: Int = 20

val SQLITE_MISUSE: Int = 21

val SQLITE_NOLFS: Int = 22

val SQLITE_AUTH: Int = 23

val SQLITE_FORMAT: Int = 24

val SQLITE_RANGE: Int = 25

val SQLITE_NOTADB: Int = 26

val SQLITE_NOTICE: Int = 27

val SQLITE_WARNING: Int = 28

val SQLITE_ROW: Int = 100

val SQLITE_DONE: Int = 101

val SQLITE_IOERR_READ: Int = 266

val SQLITE_IOERR_SHORT_READ: Int = 522

val SQLITE_IOERR_WRITE: Int = 778

val SQLITE_IOERR_FSYNC: Int = 1034

val SQLITE_IOERR_DIR_FSYNC: Int = 1290

val SQLITE_IOERR_TRUNCATE: Int = 1546

val SQLITE_IOERR_FSTAT: Int = 1802

val SQLITE_IOERR_UNLOCK: Int = 2058

val SQLITE_IOERR_RDLOCK: Int = 2314

val SQLITE_IOERR_DELETE: Int = 2570

val SQLITE_IOERR_BLOCKED: Int = 2826

val SQLITE_IOERR_NOMEM: Int = 3082

val SQLITE_IOERR_ACCESS: Int = 3338

val SQLITE_IOERR_CHECKRESERVEDLOCK: Int = 3594

val SQLITE_IOERR_LOCK: Int = 3850

val SQLITE_IOERR_CLOSE: Int = 4106

val SQLITE_IOERR_DIR_CLOSE: Int = 4362

val SQLITE_IOERR_SHMOPEN: Int = 4618

val SQLITE_IOERR_SHMSIZE: Int = 4874

val SQLITE_IOERR_SHMLOCK: Int = 5130

val SQLITE_IOERR_SHMMAP: Int = 5386

val SQLITE_IOERR_SEEK: Int = 5642

val SQLITE_IOERR_DELETE_NOENT: Int = 5898

val SQLITE_IOERR_MMAP: Int = 6154

val SQLITE_IOERR_GETTEMPPATH: Int = 6410

val SQLITE_IOERR_CONVPATH: Int = 6666

val SQLITE_IOERR_VNODE: Int = 6922

val SQLITE_IOERR_AUTH: Int = 7178

val SQLITE_LOCKED_SHAREDCACHE: Int = 262

val SQLITE_BUSY_RECOVERY: Int = 261

val SQLITE_BUSY_SNAPSHOT: Int = 517

val SQLITE_CANTOPEN_NOTEMPDIR: Int = 270

val SQLITE_CANTOPEN_ISDIR: Int = 526

val SQLITE_CANTOPEN_FULLPATH: Int = 782

val SQLITE_CANTOPEN_CONVPATH: Int = 1038

val SQLITE_CORRUPT_VTAB: Int = 267

val SQLITE_READONLY_RECOVERY: Int = 264

val SQLITE_READONLY_CANTLOCK: Int = 520

val SQLITE_READONLY_ROLLBACK: Int = 776

val SQLITE_READONLY_DBMOVED: Int = 1032

val SQLITE_ABORT_ROLLBACK: Int = 516

val SQLITE_CONSTRAINT_CHECK: Int = 275

val SQLITE_CONSTRAINT_COMMITHOOK: Int = 531

val SQLITE_CONSTRAINT_FOREIGNKEY: Int = 787

val SQLITE_CONSTRAINT_FUNCTION: Int = 1043

val SQLITE_CONSTRAINT_NOTNULL: Int = 1299

val SQLITE_CONSTRAINT_PRIMARYKEY: Int = 1555

val SQLITE_CONSTRAINT_TRIGGER: Int = 1811

val SQLITE_CONSTRAINT_UNIQUE: Int = 2067

val SQLITE_CONSTRAINT_VTAB: Int = 2323

val SQLITE_CONSTRAINT_ROWID: Int = 2579

val SQLITE_NOTICE_RECOVER_WAL: Int = 283

val SQLITE_NOTICE_RECOVER_ROLLBACK: Int = 539

val SQLITE_WARNING_AUTOINDEX: Int = 284

val SQLITE_AUTH_USER: Int = 279

val SQLITE_OPEN_READONLY: Int = 1

val SQLITE_OPEN_READWRITE: Int = 2

val SQLITE_OPEN_CREATE: Int = 4

val SQLITE_OPEN_DELETEONCLOSE: Int = 8

val SQLITE_OPEN_EXCLUSIVE: Int = 16

val SQLITE_OPEN_AUTOPROXY: Int = 32

val SQLITE_OPEN_URI: Int = 64

val SQLITE_OPEN_MEMORY: Int = 128

val SQLITE_OPEN_MAIN_DB: Int = 256

val SQLITE_OPEN_TEMP_DB: Int = 512

val SQLITE_OPEN_TRANSIENT_DB: Int = 1024

val SQLITE_OPEN_MAIN_JOURNAL: Int = 2048

val SQLITE_OPEN_TEMP_JOURNAL: Int = 4096

val SQLITE_OPEN_SUBJOURNAL: Int = 8192

val SQLITE_OPEN_MASTER_JOURNAL: Int = 16384

val SQLITE_OPEN_NOMUTEX: Int = 32768

val SQLITE_OPEN_FULLMUTEX: Int = 65536

val SQLITE_OPEN_SHAREDCACHE: Int = 131072

val SQLITE_OPEN_PRIVATECACHE: Int = 262144

val SQLITE_OPEN_WAL: Int = 524288

val SQLITE_IOCAP_ATOMIC: Int = 1

val SQLITE_IOCAP_ATOMIC512: Int = 2

val SQLITE_IOCAP_ATOMIC1K: Int = 4

val SQLITE_IOCAP_ATOMIC2K: Int = 8

val SQLITE_IOCAP_ATOMIC4K: Int = 16

val SQLITE_IOCAP_ATOMIC8K: Int = 32

val SQLITE_IOCAP_ATOMIC16K: Int = 64

val SQLITE_IOCAP_ATOMIC32K: Int = 128

val SQLITE_IOCAP_ATOMIC64K: Int = 256

val SQLITE_IOCAP_SAFE_APPEND: Int = 512

val SQLITE_IOCAP_SEQUENTIAL: Int = 1024

val SQLITE_IOCAP_UNDELETABLE_WHEN_OPEN: Int = 2048

val SQLITE_IOCAP_POWERSAFE_OVERWRITE: Int = 4096

val SQLITE_IOCAP_IMMUTABLE: Int = 8192

val SQLITE_LOCK_NONE: Int = 0

val SQLITE_LOCK_SHARED: Int = 1

val SQLITE_LOCK_RESERVED: Int = 2

val SQLITE_LOCK_PENDING: Int = 3

val SQLITE_LOCK_EXCLUSIVE: Int = 4

val SQLITE_SYNC_NORMAL: Int = 2

val SQLITE_SYNC_FULL: Int = 3

val SQLITE_SYNC_DATAONLY: Int = 16

val SQLITE_FCNTL_LOCKSTATE: Int = 1

val SQLITE_FCNTL_GET_LOCKPROXYFILE: Int = 2

val SQLITE_FCNTL_SET_LOCKPROXYFILE: Int = 3

val SQLITE_FCNTL_LAST_ERRNO: Int = 4

val SQLITE_FCNTL_SIZE_HINT: Int = 5

val SQLITE_FCNTL_CHUNK_SIZE: Int = 6

val SQLITE_FCNTL_FILE_POINTER: Int = 7

val SQLITE_FCNTL_SYNC_OMITTED: Int = 8

val SQLITE_FCNTL_WIN32_AV_RETRY: Int = 9

val SQLITE_FCNTL_PERSIST_WAL: Int = 10

val SQLITE_FCNTL_OVERWRITE: Int = 11

val SQLITE_FCNTL_VFSNAME: Int = 12

val SQLITE_FCNTL_POWERSAFE_OVERWRITE: Int = 13

val SQLITE_FCNTL_PRAGMA: Int = 14

val SQLITE_FCNTL_BUSYHANDLER: Int = 15

val SQLITE_FCNTL_TEMPFILENAME: Int = 16

val SQLITE_FCNTL_MMAP_SIZE: Int = 18

val SQLITE_FCNTL_TRACE: Int = 19

val SQLITE_FCNTL_HAS_MOVED: Int = 20

val SQLITE_FCNTL_SYNC: Int = 21

val SQLITE_FCNTL_COMMIT_PHASETWO: Int = 22

val SQLITE_FCNTL_WIN32_SET_HANDLE: Int = 23

val SQLITE_FCNTL_WAL_BLOCK: Int = 24

val SQLITE_FCNTL_ZIPVFS: Int = 25

val SQLITE_FCNTL_RBU: Int = 26

val SQLITE_FCNTL_VFS_POINTER: Int = 27

val SQLITE_FCNTL_JOURNAL_POINTER: Int = 28

val SQLITE_GET_LOCKPROXYFILE: Int = 2

val SQLITE_SET_LOCKPROXYFILE: Int = 3

val SQLITE_LAST_ERRNO: Int = 4

val SQLITE_ACCESS_EXISTS: Int = 0

val SQLITE_ACCESS_READWRITE: Int = 1

val SQLITE_ACCESS_READ: Int = 2

val SQLITE_SHM_UNLOCK: Int = 1

val SQLITE_SHM_LOCK: Int = 2

val SQLITE_SHM_SHARED: Int = 4

val SQLITE_SHM_EXCLUSIVE: Int = 8

val SQLITE_SHM_NLOCK: Int = 8

val SQLITE_CONFIG_SINGLETHREAD: Int = 1

val SQLITE_CONFIG_MULTITHREAD: Int = 2

val SQLITE_CONFIG_SERIALIZED: Int = 3

val SQLITE_CONFIG_MALLOC: Int = 4

val SQLITE_CONFIG_GETMALLOC: Int = 5

val SQLITE_CONFIG_SCRATCH: Int = 6

val SQLITE_CONFIG_PAGECACHE: Int = 7

val SQLITE_CONFIG_HEAP: Int = 8

val SQLITE_CONFIG_MEMSTATUS: Int = 9

val SQLITE_CONFIG_MUTEX: Int = 10

val SQLITE_CONFIG_GETMUTEX: Int = 11

val SQLITE_CONFIG_LOOKASIDE: Int = 13

val SQLITE_CONFIG_PCACHE: Int = 14

val SQLITE_CONFIG_GETPCACHE: Int = 15

val SQLITE_CONFIG_LOG: Int = 16

val SQLITE_CONFIG_URI: Int = 17

val SQLITE_CONFIG_PCACHE2: Int = 18

val SQLITE_CONFIG_GETPCACHE2: Int = 19

val SQLITE_CONFIG_COVERING_INDEX_SCAN: Int = 20

val SQLITE_CONFIG_SQLLOG: Int = 21

val SQLITE_CONFIG_MMAP_SIZE: Int = 22

val SQLITE_CONFIG_WIN32_HEAPSIZE: Int = 23

val SQLITE_CONFIG_PCACHE_HDRSZ: Int = 24

val SQLITE_CONFIG_PMASZ: Int = 25

val SQLITE_DBCONFIG_LOOKASIDE: Int = 1001

val SQLITE_DBCONFIG_ENABLE_FKEY: Int = 1002

val SQLITE_DBCONFIG_ENABLE_TRIGGER: Int = 1003

val SQLITE_DENY: Int = 1

val SQLITE_IGNORE: Int = 2

val SQLITE_CREATE_INDEX: Int = 1

val SQLITE_CREATE_TABLE: Int = 2

val SQLITE_CREATE_TEMP_INDEX: Int = 3

val SQLITE_CREATE_TEMP_TABLE: Int = 4

val SQLITE_CREATE_TEMP_TRIGGER: Int = 5

val SQLITE_CREATE_TEMP_VIEW: Int = 6

val SQLITE_CREATE_TRIGGER: Int = 7

val SQLITE_CREATE_VIEW: Int = 8

val SQLITE_DELETE: Int = 9

val SQLITE_DROP_INDEX: Int = 10

val SQLITE_DROP_TABLE: Int = 11

val SQLITE_DROP_TEMP_INDEX: Int = 12

val SQLITE_DROP_TEMP_TABLE: Int = 13

val SQLITE_DROP_TEMP_TRIGGER: Int = 14

val SQLITE_DROP_TEMP_VIEW: Int = 15

val SQLITE_DROP_TRIGGER: Int = 16

val SQLITE_DROP_VIEW: Int = 17

val SQLITE_INSERT: Int = 18

val SQLITE_PRAGMA: Int = 19

val SQLITE_READ: Int = 20

val SQLITE_SELECT: Int = 21

val SQLITE_TRANSACTION: Int = 22

val SQLITE_UPDATE: Int = 23

val SQLITE_ATTACH: Int = 24

val SQLITE_DETACH: Int = 25

val SQLITE_ALTER_TABLE: Int = 26

val SQLITE_REINDEX: Int = 27

val SQLITE_ANALYZE: Int = 28

val SQLITE_CREATE_VTABLE: Int = 29

val SQLITE_DROP_VTABLE: Int = 30

val SQLITE_FUNCTION: Int = 31

val SQLITE_SAVEPOINT: Int = 32

val SQLITE_COPY: Int = 0

val SQLITE_RECURSIVE: Int = 33

val SQLITE_LIMIT_LENGTH: Int = 0

val SQLITE_LIMIT_SQL_LENGTH: Int = 1

val SQLITE_LIMIT_COLUMN: Int = 2

val SQLITE_LIMIT_EXPR_DEPTH: Int = 3

val SQLITE_LIMIT_COMPOUND_SELECT: Int = 4

val SQLITE_LIMIT_VDBE_OP: Int = 5

val SQLITE_LIMIT_FUNCTION_ARG: Int = 6

val SQLITE_LIMIT_ATTACHED: Int = 7

val SQLITE_LIMIT_LIKE_PATTERN_LENGTH: Int = 8

val SQLITE_LIMIT_VARIABLE_NUMBER: Int = 9

val SQLITE_LIMIT_TRIGGER_DEPTH: Int = 10

val SQLITE_LIMIT_WORKER_THREADS: Int = 11

val SQLITE_INTEGER: Int = 1

val SQLITE_FLOAT: Int = 2

val SQLITE_BLOB: Int = 4

val SQLITE_NULL: Int = 5

val SQLITE_TEXT: Int = 3

val SQLITE3_TEXT: Int = 3

val SQLITE_UTF8: Int = 1

val SQLITE_UTF16LE: Int = 2

val SQLITE_UTF16BE: Int = 3

val SQLITE_UTF16: Int = 4

val SQLITE_ANY: Int = 5

val SQLITE_UTF16_ALIGNED: Int = 8

val SQLITE_DETERMINISTIC: Int = 2048

val SQLITE_INDEX_SCAN_UNIQUE: Int = 1

val SQLITE_INDEX_CONSTRAINT_EQ: Int = 2

val SQLITE_INDEX_CONSTRAINT_GT: Int = 4

val SQLITE_INDEX_CONSTRAINT_LE: Int = 8

val SQLITE_INDEX_CONSTRAINT_LT: Int = 16

val SQLITE_INDEX_CONSTRAINT_GE: Int = 32

val SQLITE_INDEX_CONSTRAINT_MATCH: Int = 64

val SQLITE_INDEX_CONSTRAINT_LIKE: Int = 65

val SQLITE_INDEX_CONSTRAINT_GLOB: Int = 66

val SQLITE_INDEX_CONSTRAINT_REGEXP: Int = 67

val SQLITE_MUTEX_FAST: Int = 0

val SQLITE_MUTEX_RECURSIVE: Int = 1

val SQLITE_MUTEX_STATIC_MASTER: Int = 2

val SQLITE_MUTEX_STATIC_MEM: Int = 3

val SQLITE_MUTEX_STATIC_MEM2: Int = 4

val SQLITE_MUTEX_STATIC_OPEN: Int = 4

val SQLITE_MUTEX_STATIC_PRNG: Int = 5

val SQLITE_MUTEX_STATIC_LRU: Int = 6

val SQLITE_MUTEX_STATIC_LRU2: Int = 7

val SQLITE_MUTEX_STATIC_PMEM: Int = 7

val SQLITE_MUTEX_STATIC_APP1: Int = 8

val SQLITE_MUTEX_STATIC_APP2: Int = 9

val SQLITE_MUTEX_STATIC_APP3: Int = 10

val SQLITE_MUTEX_STATIC_VFS1: Int = 11

val SQLITE_MUTEX_STATIC_VFS2: Int = 12

val SQLITE_MUTEX_STATIC_VFS3: Int = 13

val SQLITE_TESTCTRL_FIRST: Int = 5

val SQLITE_TESTCTRL_PRNG_SAVE: Int = 5

val SQLITE_TESTCTRL_PRNG_RESTORE: Int = 6

val SQLITE_TESTCTRL_PRNG_RESET: Int = 7

val SQLITE_TESTCTRL_BITVEC_TEST: Int = 8

val SQLITE_TESTCTRL_FAULT_INSTALL: Int = 9

val SQLITE_TESTCTRL_BENIGN_MALLOC_HOOKS: Int = 10

val SQLITE_TESTCTRL_PENDING_BYTE: Int = 11

val SQLITE_TESTCTRL_ASSERT: Int = 12

val SQLITE_TESTCTRL_ALWAYS: Int = 13

val SQLITE_TESTCTRL_RESERVE: Int = 14

val SQLITE_TESTCTRL_OPTIMIZATIONS: Int = 15

val SQLITE_TESTCTRL_ISKEYWORD: Int = 16

val SQLITE_TESTCTRL_SCRATCHMALLOC: Int = 17

val SQLITE_TESTCTRL_LOCALTIME_FAULT: Int = 18

val SQLITE_TESTCTRL_EXPLAIN_STMT: Int = 19

val SQLITE_TESTCTRL_NEVER_CORRUPT: Int = 20

val SQLITE_TESTCTRL_VDBE_COVERAGE: Int = 21

val SQLITE_TESTCTRL_BYTEORDER: Int = 22

val SQLITE_TESTCTRL_ISINIT: Int = 23

val SQLITE_TESTCTRL_SORTER_MMAP: Int = 24

val SQLITE_TESTCTRL_IMPOSTER: Int = 25

val SQLITE_TESTCTRL_LAST: Int = 25

val SQLITE_STATUS_MEMORY_USED: Int = 0

val SQLITE_STATUS_PAGECACHE_USED: Int = 1

val SQLITE_STATUS_PAGECACHE_OVERFLOW: Int = 2

val SQLITE_STATUS_SCRATCH_USED: Int = 3

val SQLITE_STATUS_SCRATCH_OVERFLOW: Int = 4

val SQLITE_STATUS_MALLOC_SIZE: Int = 5

val SQLITE_STATUS_PARSER_STACK: Int = 6

val SQLITE_STATUS_PAGECACHE_SIZE: Int = 7

val SQLITE_STATUS_SCRATCH_SIZE: Int = 8

val SQLITE_STATUS_MALLOC_COUNT: Int = 9

val SQLITE_DBSTATUS_LOOKASIDE_USED: Int = 0

val SQLITE_DBSTATUS_CACHE_USED: Int = 1

val SQLITE_DBSTATUS_SCHEMA_USED: Int = 2

val SQLITE_DBSTATUS_STMT_USED: Int = 3

val SQLITE_DBSTATUS_LOOKASIDE_HIT: Int = 4

val SQLITE_DBSTATUS_LOOKASIDE_MISS_SIZE: Int = 5

val SQLITE_DBSTATUS_LOOKASIDE_MISS_FULL: Int = 6

val SQLITE_DBSTATUS_CACHE_HIT: Int = 7

val SQLITE_DBSTATUS_CACHE_MISS: Int = 8

val SQLITE_DBSTATUS_CACHE_WRITE: Int = 9

val SQLITE_DBSTATUS_DEFERRED_FKS: Int = 10

val SQLITE_DBSTATUS_MAX: Int = 10

val SQLITE_STMTSTATUS_FULLSCAN_STEP: Int = 1

val SQLITE_STMTSTATUS_SORT: Int = 2

val SQLITE_STMTSTATUS_AUTOINDEX: Int = 3

val SQLITE_STMTSTATUS_VM_STEP: Int = 4

val SQLITE_CHECKPOINT_PASSIVE: Int = 0

val SQLITE_CHECKPOINT_FULL: Int = 1

val SQLITE_CHECKPOINT_RESTART: Int = 2

val SQLITE_CHECKPOINT_TRUNCATE: Int = 3

val SQLITE_VTAB_CONSTRAINT_SUPPORT: Int = 1

val SQLITE_ROLLBACK: Int = 1

val SQLITE_FAIL: Int = 3

val SQLITE_REPLACE: Int = 5

val SQLITE_SCANSTAT_NLOOP: Int = 0

val SQLITE_SCANSTAT_NVISIT: Int = 1

val SQLITE_SCANSTAT_EST: Int = 2

val SQLITE_SCANSTAT_NAME: Int = 3

val SQLITE_SCANSTAT_EXPLAIN: Int = 4

val SQLITE_SCANSTAT_SELECTID: Int = 5

val NOT_WITHIN: Int = 0

val PARTLY_WITHIN: Int = 1

val FULLY_WITHIN: Int = 2

val FTS5_TOKENIZE_QUERY: Int = 1

val FTS5_TOKENIZE_PREFIX: Int = 2

val FTS5_TOKENIZE_DOCUMENT: Int = 4

val FTS5_TOKENIZE_AUX: Int = 8

val FTS5_TOKEN_COLOCATED: Int = 1

val sqlite3_version: CArrayPointer<ByteVar>
    get() = interpretCPointer<ByteVar>(kniBridge229())!!

var sqlite3_temp_directory: CPointer<ByteVar>?
    get() = interpretPointed<CPointerVar<ByteVar>>(kniBridge230()).value
    set(value) { interpretPointed<CPointerVar<ByteVar>>(kniBridge230()).value = value }

var sqlite3_data_directory: CPointer<ByteVar>?
    get() = interpretPointed<CPointerVar<ByteVar>>(kniBridge231()).value
    set(value) { interpretPointed<CPointerVar<ByteVar>>(kniBridge231()).value = value }

class __va_list_tag(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(24, 8)
    
    var gp_offset: Int
        get() = memberAt<IntVar>(0).value
        set(value) { memberAt<IntVar>(0).value = value }
    
    var fp_offset: Int
        get() = memberAt<IntVar>(4).value
        set(value) { memberAt<IntVar>(4).value = value }
    
    var overflow_arg_area: COpaquePointer?
        get() = memberAt<COpaquePointerVar>(8).value
        set(value) { memberAt<COpaquePointerVar>(8).value = value }
    
    var reg_save_area: COpaquePointer?
        get() = memberAt<COpaquePointerVar>(16).value
        set(value) { memberAt<COpaquePointerVar>(16).value = value }
    
}


class sqlite3_file(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(8, 8)
    
    var pMethods: CPointer<sqlite3_io_methods>?
        get() = memberAt<CPointerVar<sqlite3_io_methods>>(0).value
        set(value) { memberAt<CPointerVar<sqlite3_io_methods>>(0).value = value }
    
}

class sqlite3_io_methods(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(152, 8)
    
    var iVersion: Int
        get() = memberAt<IntVar>(0).value
        set(value) { memberAt<IntVar>(0).value = value }
    
    var xClose: CPointer<CFunction<(CPointer<sqlite3_file>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?) -> Int>>>(8).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?) -> Int>>>(8).value = value }
    
    var xRead: CPointer<CFunction<(CPointer<sqlite3_file>?, COpaquePointer?, Int, sqlite3_int64) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, COpaquePointer?, Int, sqlite3_int64) -> Int>>>(16).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, COpaquePointer?, Int, sqlite3_int64) -> Int>>>(16).value = value }
    
    var xWrite: CPointer<CFunction<(CPointer<sqlite3_file>?, COpaquePointer?, Int, sqlite3_int64) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, COpaquePointer?, Int, sqlite3_int64) -> Int>>>(24).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, COpaquePointer?, Int, sqlite3_int64) -> Int>>>(24).value = value }
    
    var xTruncate: CPointer<CFunction<(CPointer<sqlite3_file>?, sqlite3_int64) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, sqlite3_int64) -> Int>>>(32).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, sqlite3_int64) -> Int>>>(32).value = value }
    
    var xSync: CPointer<CFunction<(CPointer<sqlite3_file>?, Int) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, Int) -> Int>>>(40).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, Int) -> Int>>>(40).value = value }
    
    var xFileSize: CPointer<CFunction<(CPointer<sqlite3_file>?, CPointer<sqlite3_int64Var>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, CPointer<sqlite3_int64Var>?) -> Int>>>(48).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, CPointer<sqlite3_int64Var>?) -> Int>>>(48).value = value }
    
    var xLock: CPointer<CFunction<(CPointer<sqlite3_file>?, Int) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, Int) -> Int>>>(56).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, Int) -> Int>>>(56).value = value }
    
    var xUnlock: CPointer<CFunction<(CPointer<sqlite3_file>?, Int) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, Int) -> Int>>>(64).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, Int) -> Int>>>(64).value = value }
    
    var xCheckReservedLock: CPointer<CFunction<(CPointer<sqlite3_file>?, CPointer<IntVar>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, CPointer<IntVar>?) -> Int>>>(72).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, CPointer<IntVar>?) -> Int>>>(72).value = value }
    
    var xFileControl: CPointer<CFunction<(CPointer<sqlite3_file>?, Int, COpaquePointer?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, Int, COpaquePointer?) -> Int>>>(80).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, Int, COpaquePointer?) -> Int>>>(80).value = value }
    
    var xSectorSize: CPointer<CFunction<(CPointer<sqlite3_file>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?) -> Int>>>(88).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?) -> Int>>>(88).value = value }
    
    var xDeviceCharacteristics: CPointer<CFunction<(CPointer<sqlite3_file>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?) -> Int>>>(96).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?) -> Int>>>(96).value = value }
    
    var xShmMap: CPointer<CFunction<(CPointer<sqlite3_file>?, Int, Int, Int, CPointer<COpaquePointerVar>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, Int, Int, Int, CPointer<COpaquePointerVar>?) -> Int>>>(104).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, Int, Int, Int, CPointer<COpaquePointerVar>?) -> Int>>>(104).value = value }
    
    var xShmLock: CPointer<CFunction<(CPointer<sqlite3_file>?, Int, Int, Int) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, Int, Int, Int) -> Int>>>(112).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, Int, Int, Int) -> Int>>>(112).value = value }
    
    var xShmBarrier: CPointer<CFunction<(CPointer<sqlite3_file>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?) -> Unit>>>(120).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?) -> Unit>>>(120).value = value }
    
    var xShmUnmap: CPointer<CFunction<(CPointer<sqlite3_file>?, Int) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, Int) -> Int>>>(128).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, Int) -> Int>>>(128).value = value }
    
    var xFetch: CPointer<CFunction<(CPointer<sqlite3_file>?, sqlite3_int64, Int, CPointer<COpaquePointerVar>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, sqlite3_int64, Int, CPointer<COpaquePointerVar>?) -> Int>>>(136).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, sqlite3_int64, Int, CPointer<COpaquePointerVar>?) -> Int>>>(136).value = value }
    
    var xUnfetch: CPointer<CFunction<(CPointer<sqlite3_file>?, sqlite3_int64, COpaquePointer?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, sqlite3_int64, COpaquePointer?) -> Int>>>(144).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_file>?, sqlite3_int64, COpaquePointer?) -> Int>>>(144).value = value }
    
}


class sqlite3_vfs(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(168, 8)
    
    var iVersion: Int
        get() = memberAt<IntVar>(0).value
        set(value) { memberAt<IntVar>(0).value = value }
    
    var szOsFile: Int
        get() = memberAt<IntVar>(4).value
        set(value) { memberAt<IntVar>(4).value = value }
    
    var mxPathname: Int
        get() = memberAt<IntVar>(8).value
        set(value) { memberAt<IntVar>(8).value = value }
    
    var pNext: CPointer<sqlite3_vfs>?
        get() = memberAt<CPointerVar<sqlite3_vfs>>(16).value
        set(value) { memberAt<CPointerVar<sqlite3_vfs>>(16).value = value }
    
    var zName: CPointer<ByteVar>?
        get() = memberAt<CPointerVar<ByteVar>>(24).value
        set(value) { memberAt<CPointerVar<ByteVar>>(24).value = value }
    
    var pAppData: COpaquePointer?
        get() = memberAt<COpaquePointerVar>(32).value
        set(value) { memberAt<COpaquePointerVar>(32).value = value }
    
    var xOpen: CPointer<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?, CPointer<sqlite3_file>?, Int, CPointer<IntVar>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?, CPointer<sqlite3_file>?, Int, CPointer<IntVar>?) -> Int>>>(40).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?, CPointer<sqlite3_file>?, Int, CPointer<IntVar>?) -> Int>>>(40).value = value }
    
    var xDelete: CPointer<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?, Int) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?, Int) -> Int>>>(48).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?, Int) -> Int>>>(48).value = value }
    
    var xAccess: CPointer<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?, Int, CPointer<IntVar>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?, Int, CPointer<IntVar>?) -> Int>>>(56).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?, Int, CPointer<IntVar>?) -> Int>>>(56).value = value }
    
    var xFullPathname: CPointer<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?, Int, CPointer<ByteVar>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?, Int, CPointer<ByteVar>?) -> Int>>>(64).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?, Int, CPointer<ByteVar>?) -> Int>>>(64).value = value }
    
    var xDlOpen: CPointer<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?) -> COpaquePointer?>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?) -> COpaquePointer?>>>(72).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?) -> COpaquePointer?>>>(72).value = value }
    
    var xDlError: CPointer<CFunction<(CPointer<sqlite3_vfs>?, Int, CPointer<ByteVar>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, Int, CPointer<ByteVar>?) -> Unit>>>(80).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, Int, CPointer<ByteVar>?) -> Unit>>>(80).value = value }
    
    var xDlSym: CPointer<CFunction<(CPointer<sqlite3_vfs>?, COpaquePointer?, CPointer<ByteVar>?) -> CPointer<CFunction<() -> Unit>>?>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, COpaquePointer?, CPointer<ByteVar>?) -> CPointer<CFunction<() -> Unit>>?>>>(88).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, COpaquePointer?, CPointer<ByteVar>?) -> CPointer<CFunction<() -> Unit>>?>>>(88).value = value }
    
    var xDlClose: CPointer<CFunction<(CPointer<sqlite3_vfs>?, COpaquePointer?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, COpaquePointer?) -> Unit>>>(96).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, COpaquePointer?) -> Unit>>>(96).value = value }
    
    var xRandomness: CPointer<CFunction<(CPointer<sqlite3_vfs>?, Int, CPointer<ByteVar>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, Int, CPointer<ByteVar>?) -> Int>>>(104).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, Int, CPointer<ByteVar>?) -> Int>>>(104).value = value }
    
    var xSleep: CPointer<CFunction<(CPointer<sqlite3_vfs>?, Int) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, Int) -> Int>>>(112).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, Int) -> Int>>>(112).value = value }
    
    var xCurrentTime: CPointer<CFunction<(CPointer<sqlite3_vfs>?, CPointer<DoubleVar>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<DoubleVar>?) -> Int>>>(120).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<DoubleVar>?) -> Int>>>(120).value = value }
    
    var xGetLastError: CPointer<CFunction<(CPointer<sqlite3_vfs>?, Int, CPointer<ByteVar>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, Int, CPointer<ByteVar>?) -> Int>>>(128).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, Int, CPointer<ByteVar>?) -> Int>>>(128).value = value }
    
    var xCurrentTimeInt64: CPointer<CFunction<(CPointer<sqlite3_vfs>?, CPointer<sqlite3_int64Var>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<sqlite3_int64Var>?) -> Int>>>(136).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<sqlite3_int64Var>?) -> Int>>>(136).value = value }
    
    var xSetSystemCall: CPointer<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?, sqlite3_syscall_ptr?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?, sqlite3_syscall_ptr?) -> Int>>>(144).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?, sqlite3_syscall_ptr?) -> Int>>>(144).value = value }
    
    var xGetSystemCall: CPointer<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?) -> sqlite3_syscall_ptr?>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?) -> sqlite3_syscall_ptr?>>>(152).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?) -> sqlite3_syscall_ptr?>>>(152).value = value }
    
    var xNextSystemCall: CPointer<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?) -> CPointer<ByteVar>?>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?) -> CPointer<ByteVar>?>>>(160).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vfs>?, CPointer<ByteVar>?) -> CPointer<ByteVar>?>>>(160).value = value }
    
}

class sqlite3_mem_methods(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(64, 8)
    
    var xMalloc: CPointer<CFunction<(Int) -> COpaquePointer?>>?
        get() = memberAt<CPointerVar<CFunction<(Int) -> COpaquePointer?>>>(0).value
        set(value) { memberAt<CPointerVar<CFunction<(Int) -> COpaquePointer?>>>(0).value = value }
    
    var xFree: CPointer<CFunction<(COpaquePointer?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Unit>>>(8).value
        set(value) { memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Unit>>>(8).value = value }
    
    var xRealloc: CPointer<CFunction<(COpaquePointer?, Int) -> COpaquePointer?>>?
        get() = memberAt<CPointerVar<CFunction<(COpaquePointer?, Int) -> COpaquePointer?>>>(16).value
        set(value) { memberAt<CPointerVar<CFunction<(COpaquePointer?, Int) -> COpaquePointer?>>>(16).value = value }
    
    var xSize: CPointer<CFunction<(COpaquePointer?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Int>>>(24).value
        set(value) { memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Int>>>(24).value = value }
    
    var xRoundup: CPointer<CFunction<(Int) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(Int) -> Int>>>(32).value
        set(value) { memberAt<CPointerVar<CFunction<(Int) -> Int>>>(32).value = value }
    
    var xInit: CPointer<CFunction<(COpaquePointer?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Int>>>(40).value
        set(value) { memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Int>>>(40).value = value }
    
    var xShutdown: CPointer<CFunction<(COpaquePointer?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Unit>>>(48).value
        set(value) { memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Unit>>>(48).value = value }
    
    var pAppData: COpaquePointer?
        get() = memberAt<COpaquePointerVar>(56).value
        set(value) { memberAt<COpaquePointerVar>(56).value = value }
    
}




class sqlite3_vtab(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(24, 8)
    
    var pModule: CPointer<sqlite3_module>?
        get() = memberAt<CPointerVar<sqlite3_module>>(0).value
        set(value) { memberAt<CPointerVar<sqlite3_module>>(0).value = value }
    
    var nRef: Int
        get() = memberAt<IntVar>(8).value
        set(value) { memberAt<IntVar>(8).value = value }
    
    var zErrMsg: CPointer<ByteVar>?
        get() = memberAt<CPointerVar<ByteVar>>(16).value
        set(value) { memberAt<CPointerVar<ByteVar>>(16).value = value }
    
}

class sqlite3_module(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(184, 8)
    
    var iVersion: Int
        get() = memberAt<IntVar>(0).value
        set(value) { memberAt<IntVar>(0).value = value }
    
    var xCreate: CPointer<CFunction<(CPointer<sqlite3>?, COpaquePointer?, Int, CPointer<CPointerVar<ByteVar>>?, CPointer<CPointerVar<sqlite3_vtab>>?, CPointer<CPointerVar<ByteVar>>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3>?, COpaquePointer?, Int, CPointer<CPointerVar<ByteVar>>?, CPointer<CPointerVar<sqlite3_vtab>>?, CPointer<CPointerVar<ByteVar>>?) -> Int>>>(8).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3>?, COpaquePointer?, Int, CPointer<CPointerVar<ByteVar>>?, CPointer<CPointerVar<sqlite3_vtab>>?, CPointer<CPointerVar<ByteVar>>?) -> Int>>>(8).value = value }
    
    var xConnect: CPointer<CFunction<(CPointer<sqlite3>?, COpaquePointer?, Int, CPointer<CPointerVar<ByteVar>>?, CPointer<CPointerVar<sqlite3_vtab>>?, CPointer<CPointerVar<ByteVar>>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3>?, COpaquePointer?, Int, CPointer<CPointerVar<ByteVar>>?, CPointer<CPointerVar<sqlite3_vtab>>?, CPointer<CPointerVar<ByteVar>>?) -> Int>>>(16).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3>?, COpaquePointer?, Int, CPointer<CPointerVar<ByteVar>>?, CPointer<CPointerVar<sqlite3_vtab>>?, CPointer<CPointerVar<ByteVar>>?) -> Int>>>(16).value = value }
    
    var xBestIndex: CPointer<CFunction<(CPointer<sqlite3_vtab>?, CPointer<sqlite3_index_info>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?, CPointer<sqlite3_index_info>?) -> Int>>>(24).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?, CPointer<sqlite3_index_info>?) -> Int>>>(24).value = value }
    
    var xDisconnect: CPointer<CFunction<(CPointer<sqlite3_vtab>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?) -> Int>>>(32).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?) -> Int>>>(32).value = value }
    
    var xDestroy: CPointer<CFunction<(CPointer<sqlite3_vtab>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?) -> Int>>>(40).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?) -> Int>>>(40).value = value }
    
    var xOpen: CPointer<CFunction<(CPointer<sqlite3_vtab>?, CPointer<CPointerVar<sqlite3_vtab_cursor>>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?, CPointer<CPointerVar<sqlite3_vtab_cursor>>?) -> Int>>>(48).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?, CPointer<CPointerVar<sqlite3_vtab_cursor>>?) -> Int>>>(48).value = value }
    
    var xClose: CPointer<CFunction<(CPointer<sqlite3_vtab_cursor>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab_cursor>?) -> Int>>>(56).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab_cursor>?) -> Int>>>(56).value = value }
    
    var xFilter: CPointer<CFunction<(CPointer<sqlite3_vtab_cursor>?, Int, CPointer<ByteVar>?, Int, CPointer<CPointerVar<sqlite3_value>>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab_cursor>?, Int, CPointer<ByteVar>?, Int, CPointer<CPointerVar<sqlite3_value>>?) -> Int>>>(64).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab_cursor>?, Int, CPointer<ByteVar>?, Int, CPointer<CPointerVar<sqlite3_value>>?) -> Int>>>(64).value = value }
    
    var xNext: CPointer<CFunction<(CPointer<sqlite3_vtab_cursor>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab_cursor>?) -> Int>>>(72).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab_cursor>?) -> Int>>>(72).value = value }
    
    var xEof: CPointer<CFunction<(CPointer<sqlite3_vtab_cursor>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab_cursor>?) -> Int>>>(80).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab_cursor>?) -> Int>>>(80).value = value }
    
    var xColumn: CPointer<CFunction<(CPointer<sqlite3_vtab_cursor>?, CPointer<sqlite3_context>?, Int) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab_cursor>?, CPointer<sqlite3_context>?, Int) -> Int>>>(88).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab_cursor>?, CPointer<sqlite3_context>?, Int) -> Int>>>(88).value = value }
    
    var xRowid: CPointer<CFunction<(CPointer<sqlite3_vtab_cursor>?, CPointer<sqlite3_int64Var>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab_cursor>?, CPointer<sqlite3_int64Var>?) -> Int>>>(96).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab_cursor>?, CPointer<sqlite3_int64Var>?) -> Int>>>(96).value = value }
    
    var xUpdate: CPointer<CFunction<(CPointer<sqlite3_vtab>?, Int, CPointer<CPointerVar<sqlite3_value>>?, CPointer<sqlite3_int64Var>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?, Int, CPointer<CPointerVar<sqlite3_value>>?, CPointer<sqlite3_int64Var>?) -> Int>>>(104).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?, Int, CPointer<CPointerVar<sqlite3_value>>?, CPointer<sqlite3_int64Var>?) -> Int>>>(104).value = value }
    
    var xBegin: CPointer<CFunction<(CPointer<sqlite3_vtab>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?) -> Int>>>(112).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?) -> Int>>>(112).value = value }
    
    var xSync: CPointer<CFunction<(CPointer<sqlite3_vtab>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?) -> Int>>>(120).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?) -> Int>>>(120).value = value }
    
    var xCommit: CPointer<CFunction<(CPointer<sqlite3_vtab>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?) -> Int>>>(128).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?) -> Int>>>(128).value = value }
    
    var xRollback: CPointer<CFunction<(CPointer<sqlite3_vtab>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?) -> Int>>>(136).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?) -> Int>>>(136).value = value }
    
    var xFindFunction: CPointer<CFunction<(CPointer<sqlite3_vtab>?, Int, CPointer<ByteVar>?, CPointer<CPointerVar<CFunction<(CPointer<sqlite3_context>?, Int, CPointer<CPointerVar<sqlite3_value>>?) -> Unit>>>?, CPointer<COpaquePointerVar>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?, Int, CPointer<ByteVar>?, CPointer<CPointerVar<CFunction<(CPointer<sqlite3_context>?, Int, CPointer<CPointerVar<sqlite3_value>>?) -> Unit>>>?, CPointer<COpaquePointerVar>?) -> Int>>>(144).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?, Int, CPointer<ByteVar>?, CPointer<CPointerVar<CFunction<(CPointer<sqlite3_context>?, Int, CPointer<CPointerVar<sqlite3_value>>?) -> Unit>>>?, CPointer<COpaquePointerVar>?) -> Int>>>(144).value = value }
    
    var xRename: CPointer<CFunction<(CPointer<sqlite3_vtab>?, CPointer<ByteVar>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?, CPointer<ByteVar>?) -> Int>>>(152).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?, CPointer<ByteVar>?) -> Int>>>(152).value = value }
    
    var xSavepoint: CPointer<CFunction<(CPointer<sqlite3_vtab>?, Int) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?, Int) -> Int>>>(160).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?, Int) -> Int>>>(160).value = value }
    
    var xRelease: CPointer<CFunction<(CPointer<sqlite3_vtab>?, Int) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?, Int) -> Int>>>(168).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?, Int) -> Int>>>(168).value = value }
    
    var xRollbackTo: CPointer<CFunction<(CPointer<sqlite3_vtab>?, Int) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?, Int) -> Int>>>(176).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_vtab>?, Int) -> Int>>>(176).value = value }
    
}

class sqlite3_index_info(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(96, 8)
    
    var nConstraint: Int
        get() = memberAt<IntVar>(0).value
        set(value) { memberAt<IntVar>(0).value = value }
    
    var aConstraint: CPointer<sqlite3_index_constraint>?
        get() = memberAt<CPointerVar<sqlite3_index_constraint>>(8).value
        set(value) { memberAt<CPointerVar<sqlite3_index_constraint>>(8).value = value }
    
    var nOrderBy: Int
        get() = memberAt<IntVar>(16).value
        set(value) { memberAt<IntVar>(16).value = value }
    
    var aOrderBy: CPointer<sqlite3_index_orderby>?
        get() = memberAt<CPointerVar<sqlite3_index_orderby>>(24).value
        set(value) { memberAt<CPointerVar<sqlite3_index_orderby>>(24).value = value }
    
    var aConstraintUsage: CPointer<sqlite3_index_constraint_usage>?
        get() = memberAt<CPointerVar<sqlite3_index_constraint_usage>>(32).value
        set(value) { memberAt<CPointerVar<sqlite3_index_constraint_usage>>(32).value = value }
    
    var idxNum: Int
        get() = memberAt<IntVar>(40).value
        set(value) { memberAt<IntVar>(40).value = value }
    
    var idxStr: CPointer<ByteVar>?
        get() = memberAt<CPointerVar<ByteVar>>(48).value
        set(value) { memberAt<CPointerVar<ByteVar>>(48).value = value }
    
    var needToFreeIdxStr: Int
        get() = memberAt<IntVar>(56).value
        set(value) { memberAt<IntVar>(56).value = value }
    
    var orderByConsumed: Int
        get() = memberAt<IntVar>(60).value
        set(value) { memberAt<IntVar>(60).value = value }
    
    var estimatedCost: Double
        get() = memberAt<DoubleVar>(64).value
        set(value) { memberAt<DoubleVar>(64).value = value }
    
    var estimatedRows: sqlite3_int64
        get() = memberAt<sqlite3_int64Var>(72).value
        set(value) { memberAt<sqlite3_int64Var>(72).value = value }
    
    var idxFlags: Int
        get() = memberAt<IntVar>(80).value
        set(value) { memberAt<IntVar>(80).value = value }
    
    var colUsed: sqlite3_uint64
        get() = memberAt<sqlite3_uint64Var>(88).value
        set(value) { memberAt<sqlite3_uint64Var>(88).value = value }
    
}

class sqlite3_index_constraint(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(12, 4)
    
    var iColumn: Int
        get() = memberAt<IntVar>(0).value
        set(value) { memberAt<IntVar>(0).value = value }
    
    var op: Byte
        get() = memberAt<ByteVar>(4).value
        set(value) { memberAt<ByteVar>(4).value = value }
    
    var usable: Byte
        get() = memberAt<ByteVar>(5).value
        set(value) { memberAt<ByteVar>(5).value = value }
    
    var iTermOffset: Int
        get() = memberAt<IntVar>(8).value
        set(value) { memberAt<IntVar>(8).value = value }
    
}

class sqlite3_index_orderby(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(8, 4)
    
    var iColumn: Int
        get() = memberAt<IntVar>(0).value
        set(value) { memberAt<IntVar>(0).value = value }
    
    var desc: Byte
        get() = memberAt<ByteVar>(4).value
        set(value) { memberAt<ByteVar>(4).value = value }
    
}

class sqlite3_index_constraint_usage(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(8, 4)
    
    var argvIndex: Int
        get() = memberAt<IntVar>(0).value
        set(value) { memberAt<IntVar>(0).value = value }
    
    var omit: Byte
        get() = memberAt<ByteVar>(4).value
        set(value) { memberAt<ByteVar>(4).value = value }
    
}

class sqlite3_vtab_cursor(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(8, 8)
    
    var pVtab: CPointer<sqlite3_vtab>?
        get() = memberAt<CPointerVar<sqlite3_vtab>>(0).value
        set(value) { memberAt<CPointerVar<sqlite3_vtab>>(0).value = value }
    
}


class sqlite3_mutex_methods(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(72, 8)
    
    var xMutexInit: CPointer<CFunction<() -> Int>>?
        get() = memberAt<CPointerVar<CFunction<() -> Int>>>(0).value
        set(value) { memberAt<CPointerVar<CFunction<() -> Int>>>(0).value = value }
    
    var xMutexEnd: CPointer<CFunction<() -> Int>>?
        get() = memberAt<CPointerVar<CFunction<() -> Int>>>(8).value
        set(value) { memberAt<CPointerVar<CFunction<() -> Int>>>(8).value = value }
    
    var xMutexAlloc: CPointer<CFunction<(Int) -> CPointer<sqlite3_mutex>?>>?
        get() = memberAt<CPointerVar<CFunction<(Int) -> CPointer<sqlite3_mutex>?>>>(16).value
        set(value) { memberAt<CPointerVar<CFunction<(Int) -> CPointer<sqlite3_mutex>?>>>(16).value = value }
    
    var xMutexFree: CPointer<CFunction<(CPointer<sqlite3_mutex>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_mutex>?) -> Unit>>>(24).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_mutex>?) -> Unit>>>(24).value = value }
    
    var xMutexEnter: CPointer<CFunction<(CPointer<sqlite3_mutex>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_mutex>?) -> Unit>>>(32).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_mutex>?) -> Unit>>>(32).value = value }
    
    var xMutexTry: CPointer<CFunction<(CPointer<sqlite3_mutex>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_mutex>?) -> Int>>>(40).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_mutex>?) -> Int>>>(40).value = value }
    
    var xMutexLeave: CPointer<CFunction<(CPointer<sqlite3_mutex>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_mutex>?) -> Unit>>>(48).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_mutex>?) -> Unit>>>(48).value = value }
    
    var xMutexHeld: CPointer<CFunction<(CPointer<sqlite3_mutex>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_mutex>?) -> Int>>>(56).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_mutex>?) -> Int>>>(56).value = value }
    
    var xMutexNotheld: CPointer<CFunction<(CPointer<sqlite3_mutex>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_mutex>?) -> Int>>>(64).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_mutex>?) -> Int>>>(64).value = value }
    
}


class sqlite3_pcache_page(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(16, 8)
    
    var pBuf: COpaquePointer?
        get() = memberAt<COpaquePointerVar>(0).value
        set(value) { memberAt<COpaquePointerVar>(0).value = value }
    
    var pExtra: COpaquePointer?
        get() = memberAt<COpaquePointerVar>(8).value
        set(value) { memberAt<COpaquePointerVar>(8).value = value }
    
}

class sqlite3_pcache_methods2(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(104, 8)
    
    var iVersion: Int
        get() = memberAt<IntVar>(0).value
        set(value) { memberAt<IntVar>(0).value = value }
    
    var pArg: COpaquePointer?
        get() = memberAt<COpaquePointerVar>(8).value
        set(value) { memberAt<COpaquePointerVar>(8).value = value }
    
    var xInit: CPointer<CFunction<(COpaquePointer?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Int>>>(16).value
        set(value) { memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Int>>>(16).value = value }
    
    var xShutdown: CPointer<CFunction<(COpaquePointer?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Unit>>>(24).value
        set(value) { memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Unit>>>(24).value = value }
    
    var xCreate: CPointer<CFunction<(Int, Int, Int) -> CPointer<sqlite3_pcache>?>>?
        get() = memberAt<CPointerVar<CFunction<(Int, Int, Int) -> CPointer<sqlite3_pcache>?>>>(32).value
        set(value) { memberAt<CPointerVar<CFunction<(Int, Int, Int) -> CPointer<sqlite3_pcache>?>>>(32).value = value }
    
    var xCachesize: CPointer<CFunction<(CPointer<sqlite3_pcache>?, Int) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, Int) -> Unit>>>(40).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, Int) -> Unit>>>(40).value = value }
    
    var xPagecount: CPointer<CFunction<(CPointer<sqlite3_pcache>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?) -> Int>>>(48).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?) -> Int>>>(48).value = value }
    
    var xFetch: CPointer<CFunction<(CPointer<sqlite3_pcache>?, Int, Int) -> CPointer<sqlite3_pcache_page>?>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, Int, Int) -> CPointer<sqlite3_pcache_page>?>>>(56).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, Int, Int) -> CPointer<sqlite3_pcache_page>?>>>(56).value = value }
    
    var xUnpin: CPointer<CFunction<(CPointer<sqlite3_pcache>?, CPointer<sqlite3_pcache_page>?, Int) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, CPointer<sqlite3_pcache_page>?, Int) -> Unit>>>(64).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, CPointer<sqlite3_pcache_page>?, Int) -> Unit>>>(64).value = value }
    
    var xRekey: CPointer<CFunction<(CPointer<sqlite3_pcache>?, CPointer<sqlite3_pcache_page>?, Int, Int) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, CPointer<sqlite3_pcache_page>?, Int, Int) -> Unit>>>(72).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, CPointer<sqlite3_pcache_page>?, Int, Int) -> Unit>>>(72).value = value }
    
    var xTruncate: CPointer<CFunction<(CPointer<sqlite3_pcache>?, Int) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, Int) -> Unit>>>(80).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, Int) -> Unit>>>(80).value = value }
    
    var xDestroy: CPointer<CFunction<(CPointer<sqlite3_pcache>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?) -> Unit>>>(88).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?) -> Unit>>>(88).value = value }
    
    var xShrink: CPointer<CFunction<(CPointer<sqlite3_pcache>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?) -> Unit>>>(96).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?) -> Unit>>>(96).value = value }
    
}

class sqlite3_pcache_methods(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(88, 8)
    
    var pArg: COpaquePointer?
        get() = memberAt<COpaquePointerVar>(0).value
        set(value) { memberAt<COpaquePointerVar>(0).value = value }
    
    var xInit: CPointer<CFunction<(COpaquePointer?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Int>>>(8).value
        set(value) { memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Int>>>(8).value = value }
    
    var xShutdown: CPointer<CFunction<(COpaquePointer?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Unit>>>(16).value
        set(value) { memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Unit>>>(16).value = value }
    
    var xCreate: CPointer<CFunction<(Int, Int) -> CPointer<sqlite3_pcache>?>>?
        get() = memberAt<CPointerVar<CFunction<(Int, Int) -> CPointer<sqlite3_pcache>?>>>(24).value
        set(value) { memberAt<CPointerVar<CFunction<(Int, Int) -> CPointer<sqlite3_pcache>?>>>(24).value = value }
    
    var xCachesize: CPointer<CFunction<(CPointer<sqlite3_pcache>?, Int) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, Int) -> Unit>>>(32).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, Int) -> Unit>>>(32).value = value }
    
    var xPagecount: CPointer<CFunction<(CPointer<sqlite3_pcache>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?) -> Int>>>(40).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?) -> Int>>>(40).value = value }
    
    var xFetch: CPointer<CFunction<(CPointer<sqlite3_pcache>?, Int, Int) -> COpaquePointer?>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, Int, Int) -> COpaquePointer?>>>(48).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, Int, Int) -> COpaquePointer?>>>(48).value = value }
    
    var xUnpin: CPointer<CFunction<(CPointer<sqlite3_pcache>?, COpaquePointer?, Int) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, COpaquePointer?, Int) -> Unit>>>(56).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, COpaquePointer?, Int) -> Unit>>>(56).value = value }
    
    var xRekey: CPointer<CFunction<(CPointer<sqlite3_pcache>?, COpaquePointer?, Int, Int) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, COpaquePointer?, Int, Int) -> Unit>>>(64).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, COpaquePointer?, Int, Int) -> Unit>>>(64).value = value }
    
    var xTruncate: CPointer<CFunction<(CPointer<sqlite3_pcache>?, Int) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, Int) -> Unit>>>(72).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?, Int) -> Unit>>>(72).value = value }
    
    var xDestroy: CPointer<CFunction<(CPointer<sqlite3_pcache>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?) -> Unit>>>(80).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<sqlite3_pcache>?) -> Unit>>>(80).value = value }
    
}



class sqlite3_rtree_geometry(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(40, 8)
    
    var pContext: COpaquePointer?
        get() = memberAt<COpaquePointerVar>(0).value
        set(value) { memberAt<COpaquePointerVar>(0).value = value }
    
    var nParam: Int
        get() = memberAt<IntVar>(8).value
        set(value) { memberAt<IntVar>(8).value = value }
    
    var aParam: CPointer<sqlite3_rtree_dblVar>?
        get() = memberAt<CPointerVar<sqlite3_rtree_dblVar>>(16).value
        set(value) { memberAt<CPointerVar<sqlite3_rtree_dblVar>>(16).value = value }
    
    var pUser: COpaquePointer?
        get() = memberAt<COpaquePointerVar>(24).value
        set(value) { memberAt<COpaquePointerVar>(24).value = value }
    
    var xDelUser: CPointer<CFunction<(COpaquePointer?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Unit>>>(32).value
        set(value) { memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Unit>>>(32).value = value }
    
}

class sqlite3_rtree_query_info(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(112, 8)
    
    var pContext: COpaquePointer?
        get() = memberAt<COpaquePointerVar>(0).value
        set(value) { memberAt<COpaquePointerVar>(0).value = value }
    
    var nParam: Int
        get() = memberAt<IntVar>(8).value
        set(value) { memberAt<IntVar>(8).value = value }
    
    var aParam: CPointer<sqlite3_rtree_dblVar>?
        get() = memberAt<CPointerVar<sqlite3_rtree_dblVar>>(16).value
        set(value) { memberAt<CPointerVar<sqlite3_rtree_dblVar>>(16).value = value }
    
    var pUser: COpaquePointer?
        get() = memberAt<COpaquePointerVar>(24).value
        set(value) { memberAt<COpaquePointerVar>(24).value = value }
    
    var xDelUser: CPointer<CFunction<(COpaquePointer?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Unit>>>(32).value
        set(value) { memberAt<CPointerVar<CFunction<(COpaquePointer?) -> Unit>>>(32).value = value }
    
    var aCoord: CPointer<sqlite3_rtree_dblVar>?
        get() = memberAt<CPointerVar<sqlite3_rtree_dblVar>>(40).value
        set(value) { memberAt<CPointerVar<sqlite3_rtree_dblVar>>(40).value = value }
    
    var anQueue: CPointer<IntVar>?
        get() = memberAt<CPointerVar<IntVar>>(48).value
        set(value) { memberAt<CPointerVar<IntVar>>(48).value = value }
    
    var nCoord: Int
        get() = memberAt<IntVar>(56).value
        set(value) { memberAt<IntVar>(56).value = value }
    
    var iLevel: Int
        get() = memberAt<IntVar>(60).value
        set(value) { memberAt<IntVar>(60).value = value }
    
    var mxLevel: Int
        get() = memberAt<IntVar>(64).value
        set(value) { memberAt<IntVar>(64).value = value }
    
    var iRowid: sqlite3_int64
        get() = memberAt<sqlite3_int64Var>(72).value
        set(value) { memberAt<sqlite3_int64Var>(72).value = value }
    
    var rParentScore: sqlite3_rtree_dbl
        get() = memberAt<sqlite3_rtree_dblVar>(80).value
        set(value) { memberAt<sqlite3_rtree_dblVar>(80).value = value }
    
    var eParentWithin: Int
        get() = memberAt<IntVar>(88).value
        set(value) { memberAt<IntVar>(88).value = value }
    
    var eWithin: Int
        get() = memberAt<IntVar>(92).value
        set(value) { memberAt<IntVar>(92).value = value }
    
    var rScore: sqlite3_rtree_dbl
        get() = memberAt<sqlite3_rtree_dblVar>(96).value
        set(value) { memberAt<sqlite3_rtree_dblVar>(96).value = value }
    
    var apSqlParam: CPointer<CPointerVar<sqlite3_value>>?
        get() = memberAt<CPointerVar<CPointerVar<sqlite3_value>>>(104).value
        set(value) { memberAt<CPointerVar<CPointerVar<sqlite3_value>>>(104).value = value }
    
}

class Fts5ExtensionApi(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(160, 8)
    
    var iVersion: Int
        get() = memberAt<IntVar>(0).value
        set(value) { memberAt<IntVar>(0).value = value }
    
    var xUserData: CPointer<CFunction<(CPointer<Fts5Context>?) -> COpaquePointer?>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?) -> COpaquePointer?>>>(8).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?) -> COpaquePointer?>>>(8).value = value }
    
    var xColumnCount: CPointer<CFunction<(CPointer<Fts5Context>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?) -> Int>>>(16).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?) -> Int>>>(16).value = value }
    
    var xRowCount: CPointer<CFunction<(CPointer<Fts5Context>?, CPointer<sqlite3_int64Var>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, CPointer<sqlite3_int64Var>?) -> Int>>>(24).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, CPointer<sqlite3_int64Var>?) -> Int>>>(24).value = value }
    
    var xColumnTotalSize: CPointer<CFunction<(CPointer<Fts5Context>?, Int, CPointer<sqlite3_int64Var>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, Int, CPointer<sqlite3_int64Var>?) -> Int>>>(32).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, Int, CPointer<sqlite3_int64Var>?) -> Int>>>(32).value = value }
    
    var xTokenize: CPointer<CFunction<(CPointer<Fts5Context>?, CPointer<ByteVar>?, Int, COpaquePointer?, CPointer<CFunction<(COpaquePointer?, Int, CPointer<ByteVar>?, Int, Int, Int) -> Int>>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, CPointer<ByteVar>?, Int, COpaquePointer?, CPointer<CFunction<(COpaquePointer?, Int, CPointer<ByteVar>?, Int, Int, Int) -> Int>>?) -> Int>>>(40).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, CPointer<ByteVar>?, Int, COpaquePointer?, CPointer<CFunction<(COpaquePointer?, Int, CPointer<ByteVar>?, Int, Int, Int) -> Int>>?) -> Int>>>(40).value = value }
    
    var xPhraseCount: CPointer<CFunction<(CPointer<Fts5Context>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?) -> Int>>>(48).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?) -> Int>>>(48).value = value }
    
    var xPhraseSize: CPointer<CFunction<(CPointer<Fts5Context>?, Int) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, Int) -> Int>>>(56).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, Int) -> Int>>>(56).value = value }
    
    var xInstCount: CPointer<CFunction<(CPointer<Fts5Context>?, CPointer<IntVar>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, CPointer<IntVar>?) -> Int>>>(64).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, CPointer<IntVar>?) -> Int>>>(64).value = value }
    
    var xInst: CPointer<CFunction<(CPointer<Fts5Context>?, Int, CPointer<IntVar>?, CPointer<IntVar>?, CPointer<IntVar>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, Int, CPointer<IntVar>?, CPointer<IntVar>?, CPointer<IntVar>?) -> Int>>>(72).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, Int, CPointer<IntVar>?, CPointer<IntVar>?, CPointer<IntVar>?) -> Int>>>(72).value = value }
    
    var xRowid: CPointer<CFunction<(CPointer<Fts5Context>?) -> sqlite3_int64>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?) -> sqlite3_int64>>>(80).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?) -> sqlite3_int64>>>(80).value = value }
    
    var xColumnText: CPointer<CFunction<(CPointer<Fts5Context>?, Int, CPointer<CPointerVar<ByteVar>>?, CPointer<IntVar>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, Int, CPointer<CPointerVar<ByteVar>>?, CPointer<IntVar>?) -> Int>>>(88).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, Int, CPointer<CPointerVar<ByteVar>>?, CPointer<IntVar>?) -> Int>>>(88).value = value }
    
    var xColumnSize: CPointer<CFunction<(CPointer<Fts5Context>?, Int, CPointer<IntVar>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, Int, CPointer<IntVar>?) -> Int>>>(96).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, Int, CPointer<IntVar>?) -> Int>>>(96).value = value }
    
    var xQueryPhrase: CPointer<CFunction<(CPointer<Fts5Context>?, Int, COpaquePointer?, CPointer<CFunction<(CPointer<Fts5ExtensionApi>?, CPointer<Fts5Context>?, COpaquePointer?) -> Int>>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, Int, COpaquePointer?, CPointer<CFunction<(CPointer<Fts5ExtensionApi>?, CPointer<Fts5Context>?, COpaquePointer?) -> Int>>?) -> Int>>>(104).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, Int, COpaquePointer?, CPointer<CFunction<(CPointer<Fts5ExtensionApi>?, CPointer<Fts5Context>?, COpaquePointer?) -> Int>>?) -> Int>>>(104).value = value }
    
    var xSetAuxdata: CPointer<CFunction<(CPointer<Fts5Context>?, COpaquePointer?, CPointer<CFunction<(COpaquePointer?) -> Unit>>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, COpaquePointer?, CPointer<CFunction<(COpaquePointer?) -> Unit>>?) -> Int>>>(112).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, COpaquePointer?, CPointer<CFunction<(COpaquePointer?) -> Unit>>?) -> Int>>>(112).value = value }
    
    var xGetAuxdata: CPointer<CFunction<(CPointer<Fts5Context>?, Int) -> COpaquePointer?>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, Int) -> COpaquePointer?>>>(120).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, Int) -> COpaquePointer?>>>(120).value = value }
    
    var xPhraseFirst: CPointer<CFunction<(CPointer<Fts5Context>?, Int, CPointer<Fts5PhraseIter>?, CPointer<IntVar>?, CPointer<IntVar>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, Int, CPointer<Fts5PhraseIter>?, CPointer<IntVar>?, CPointer<IntVar>?) -> Int>>>(128).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, Int, CPointer<Fts5PhraseIter>?, CPointer<IntVar>?, CPointer<IntVar>?) -> Int>>>(128).value = value }
    
    var xPhraseNext: CPointer<CFunction<(CPointer<Fts5Context>?, CPointer<Fts5PhraseIter>?, CPointer<IntVar>?, CPointer<IntVar>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, CPointer<Fts5PhraseIter>?, CPointer<IntVar>?, CPointer<IntVar>?) -> Unit>>>(136).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, CPointer<Fts5PhraseIter>?, CPointer<IntVar>?, CPointer<IntVar>?) -> Unit>>>(136).value = value }
    
    var xPhraseFirstColumn: CPointer<CFunction<(CPointer<Fts5Context>?, Int, CPointer<Fts5PhraseIter>?, CPointer<IntVar>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, Int, CPointer<Fts5PhraseIter>?, CPointer<IntVar>?) -> Int>>>(144).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, Int, CPointer<Fts5PhraseIter>?, CPointer<IntVar>?) -> Int>>>(144).value = value }
    
    var xPhraseNextColumn: CPointer<CFunction<(CPointer<Fts5Context>?, CPointer<Fts5PhraseIter>?, CPointer<IntVar>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, CPointer<Fts5PhraseIter>?, CPointer<IntVar>?) -> Unit>>>(152).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Context>?, CPointer<Fts5PhraseIter>?, CPointer<IntVar>?) -> Unit>>>(152).value = value }
    
}


class Fts5PhraseIter(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(16, 8)
    
    var a: CPointer<ByteVar>?
        get() = memberAt<CPointerVar<ByteVar>>(0).value
        set(value) { memberAt<CPointerVar<ByteVar>>(0).value = value }
    
    var b: CPointer<ByteVar>?
        get() = memberAt<CPointerVar<ByteVar>>(8).value
        set(value) { memberAt<CPointerVar<ByteVar>>(8).value = value }
    
}


class fts5_tokenizer(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(24, 8)
    
    var xCreate: CPointer<CFunction<(COpaquePointer?, CPointer<CPointerVar<ByteVar>>?, Int, CPointer<CPointerVar<Fts5Tokenizer>>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(COpaquePointer?, CPointer<CPointerVar<ByteVar>>?, Int, CPointer<CPointerVar<Fts5Tokenizer>>?) -> Int>>>(0).value
        set(value) { memberAt<CPointerVar<CFunction<(COpaquePointer?, CPointer<CPointerVar<ByteVar>>?, Int, CPointer<CPointerVar<Fts5Tokenizer>>?) -> Int>>>(0).value = value }
    
    var xDelete: CPointer<CFunction<(CPointer<Fts5Tokenizer>?) -> Unit>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Tokenizer>?) -> Unit>>>(8).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Tokenizer>?) -> Unit>>>(8).value = value }
    
    var xTokenize: CPointer<CFunction<(CPointer<Fts5Tokenizer>?, COpaquePointer?, Int, CPointer<ByteVar>?, Int, CPointer<CFunction<(COpaquePointer?, Int, CPointer<ByteVar>?, Int, Int, Int) -> Int>>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<Fts5Tokenizer>?, COpaquePointer?, Int, CPointer<ByteVar>?, Int, CPointer<CFunction<(COpaquePointer?, Int, CPointer<ByteVar>?, Int, Int, Int) -> Int>>?) -> Int>>>(16).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<Fts5Tokenizer>?, COpaquePointer?, Int, CPointer<ByteVar>?, Int, CPointer<CFunction<(COpaquePointer?, Int, CPointer<ByteVar>?, Int, Int, Int) -> Int>>?) -> Int>>>(16).value = value }
    
}

class fts5_api(rawPtr: NativePtr) : CStructVar(rawPtr) {
    
    companion object : Type(32, 8)
    
    var iVersion: Int
        get() = memberAt<IntVar>(0).value
        set(value) { memberAt<IntVar>(0).value = value }
    
    var xCreateTokenizer: CPointer<CFunction<(CPointer<fts5_api>?, CPointer<ByteVar>?, COpaquePointer?, CPointer<fts5_tokenizer>?, CPointer<CFunction<(COpaquePointer?) -> Unit>>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<fts5_api>?, CPointer<ByteVar>?, COpaquePointer?, CPointer<fts5_tokenizer>?, CPointer<CFunction<(COpaquePointer?) -> Unit>>?) -> Int>>>(8).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<fts5_api>?, CPointer<ByteVar>?, COpaquePointer?, CPointer<fts5_tokenizer>?, CPointer<CFunction<(COpaquePointer?) -> Unit>>?) -> Int>>>(8).value = value }
    
    var xFindTokenizer: CPointer<CFunction<(CPointer<fts5_api>?, CPointer<ByteVar>?, CPointer<COpaquePointerVar>?, CPointer<fts5_tokenizer>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<fts5_api>?, CPointer<ByteVar>?, CPointer<COpaquePointerVar>?, CPointer<fts5_tokenizer>?) -> Int>>>(16).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<fts5_api>?, CPointer<ByteVar>?, CPointer<COpaquePointerVar>?, CPointer<fts5_tokenizer>?) -> Int>>>(16).value = value }
    
    var xCreateFunction: CPointer<CFunction<(CPointer<fts5_api>?, CPointer<ByteVar>?, COpaquePointer?, fts5_extension_function?, CPointer<CFunction<(COpaquePointer?) -> Unit>>?) -> Int>>?
        get() = memberAt<CPointerVar<CFunction<(CPointer<fts5_api>?, CPointer<ByteVar>?, COpaquePointer?, fts5_extension_function?, CPointer<CFunction<(COpaquePointer?) -> Unit>>?) -> Int>>>(24).value
        set(value) { memberAt<CPointerVar<CFunction<(CPointer<fts5_api>?, CPointer<ByteVar>?, COpaquePointer?, fts5_extension_function?, CPointer<CFunction<(COpaquePointer?) -> Unit>>?) -> Int>>>(24).value = value }
    
}

typealias __builtin_va_listVar = CPointerVarOf<__builtin_va_list>
typealias __builtin_va_list = CArrayPointer<__va_list_tag>

typealias va_listVar = CPointerVarOf<va_list>
typealias va_list = __builtin_va_list

typealias __gnuc_va_listVar = CPointerVarOf<__gnuc_va_list>
typealias __gnuc_va_list = __builtin_va_list

typealias sqlite_int64Var = LongVarOf<sqlite_int64>
typealias sqlite_int64 = Long

typealias sqlite_uint64Var = LongVarOf<sqlite_uint64>
typealias sqlite_uint64 = Long

typealias sqlite3_int64Var = LongVarOf<sqlite3_int64>
typealias sqlite3_int64 = sqlite_int64

typealias sqlite3_uint64Var = LongVarOf<sqlite3_uint64>
typealias sqlite3_uint64 = sqlite_uint64

typealias sqlite3_callbackVar = CPointerVarOf<sqlite3_callback>
typealias sqlite3_callback = CPointer<CFunction<(COpaquePointer?, Int, CPointer<CPointerVar<ByteVar>>?, CPointer<CPointerVar<ByteVar>>?) -> Int>>

typealias sqlite3_syscall_ptrVar = CPointerVarOf<sqlite3_syscall_ptr>
typealias sqlite3_syscall_ptr = CPointer<CFunction<() -> Unit>>

typealias sqlite3_value = Mem

typealias sqlite3_destructor_typeVar = CPointerVarOf<sqlite3_destructor_type>
typealias sqlite3_destructor_type = CPointer<CFunction<(COpaquePointer?) -> Unit>>

typealias sqlite3_rtree_dblVar = DoubleVarOf<sqlite3_rtree_dbl>
typealias sqlite3_rtree_dbl = Double

typealias fts5_extension_functionVar = CPointerVarOf<fts5_extension_function>
typealias fts5_extension_function = CPointer<CFunction<(CPointer<Fts5ExtensionApi>?, CPointer<Fts5Context>?, CPointer<sqlite3_context>?, Int, CPointer<CPointerVar<sqlite3_value>>?) -> Unit>>

@SymbolName("sqlite3_kniBridge0")
private external fun kniBridge0(): NativePtr
@SymbolName("sqlite3_kniBridge1")
private external fun kniBridge1(): NativePtr
@SymbolName("sqlite3_kniBridge2")
private external fun kniBridge2(): Int
@SymbolName("sqlite3_kniBridge3")
private external fun kniBridge3(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge4")
private external fun kniBridge4(p0: Int): NativePtr
@SymbolName("sqlite3_kniBridge5")
private external fun kniBridge5(): Int
@SymbolName("sqlite3_kniBridge6")
private external fun kniBridge6(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge7")
private external fun kniBridge7(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge8")
private external fun kniBridge8(p0: NativePtr, p1: NativePtr, p2: NativePtr, p3: NativePtr, p4: NativePtr): Int
@SymbolName("sqlite3_kniBridge9")
private external fun kniBridge9(): Int
@SymbolName("sqlite3_kniBridge10")
private external fun kniBridge10(): Int
@SymbolName("sqlite3_kniBridge11")
private external fun kniBridge11(): Int
@SymbolName("sqlite3_kniBridge12")
private external fun kniBridge12(): Int
@SymbolName("sqlite3_kniBridge13")
private external fun kniBridge13(): NativePtr
@SymbolName("sqlite3_kniBridge14")
private external fun kniBridge14(): NativePtr
@SymbolName("sqlite3_kniBridge15")
private external fun kniBridge15(p0: NativePtr, p1: Int): Int
@SymbolName("sqlite3_kniBridge16")
private external fun kniBridge16(p0: NativePtr): Long
@SymbolName("sqlite3_kniBridge17")
private external fun kniBridge17(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge18")
private external fun kniBridge18(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge19")
private external fun kniBridge19(p0: NativePtr): Unit
@SymbolName("sqlite3_kniBridge20")
private external fun kniBridge20(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge21")
private external fun kniBridge21(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge22")
private external fun kniBridge22(p0: NativePtr, p1: NativePtr, p2: NativePtr): Int
@SymbolName("sqlite3_kniBridge23")
private external fun kniBridge23(p0: NativePtr, p1: Int): Int
@SymbolName("sqlite3_kniBridge24")
private external fun kniBridge24(p0: NativePtr, p1: NativePtr, p2: NativePtr, p3: NativePtr, p4: NativePtr, p5: NativePtr): Int
@SymbolName("sqlite3_kniBridge25")
private external fun kniBridge25(p0: NativePtr): Unit
@SymbolName("sqlite3_kniBridge26")
private external fun kniBridge26(): NativePtr
@SymbolName("sqlite3_kniBridge27")
private external fun kniBridge27(p0: NativePtr, p1: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge28")
private external fun kniBridge28(): NativePtr
@SymbolName("sqlite3_kniBridge29")
private external fun kniBridge29(p0: Int, p1: NativePtr, p2: NativePtr, p3: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge30")
private external fun kniBridge30(p0: Int): NativePtr
@SymbolName("sqlite3_kniBridge31")
private external fun kniBridge31(p0: Long): NativePtr
@SymbolName("sqlite3_kniBridge32")
private external fun kniBridge32(p0: NativePtr, p1: Int): NativePtr
@SymbolName("sqlite3_kniBridge33")
private external fun kniBridge33(p0: NativePtr, p1: Long): NativePtr
@SymbolName("sqlite3_kniBridge34")
private external fun kniBridge34(p0: NativePtr): Unit
@SymbolName("sqlite3_kniBridge35")
private external fun kniBridge35(p0: NativePtr): Long
@SymbolName("sqlite3_kniBridge36")
private external fun kniBridge36(): Long
@SymbolName("sqlite3_kniBridge37")
private external fun kniBridge37(p0: Int): Long
@SymbolName("sqlite3_kniBridge38")
private external fun kniBridge38(p0: Int, p1: NativePtr): Unit
@SymbolName("sqlite3_kniBridge39")
private external fun kniBridge39(p0: NativePtr, p1: NativePtr, p2: NativePtr): Int
@SymbolName("sqlite3_kniBridge40")
private external fun kniBridge40(p0: NativePtr, p1: NativePtr, p2: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge41")
private external fun kniBridge41(p0: NativePtr, p1: NativePtr, p2: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge42")
private external fun kniBridge42(p0: NativePtr, p1: Int, p2: NativePtr, p3: NativePtr): Unit
@SymbolName("sqlite3_kniBridge43")
private external fun kniBridge43(p0: NativePtr, p1: NativePtr): Int
@SymbolName("sqlite3_kniBridge44")
private external fun kniBridge44(p0: NativePtr, p1: NativePtr): Int
@SymbolName("sqlite3_kniBridge45")
private external fun kniBridge45(p0: NativePtr, p1: NativePtr, p2: Int, p3: NativePtr): Int
@SymbolName("sqlite3_kniBridge46")
private external fun kniBridge46(p0: NativePtr, p1: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge47")
private external fun kniBridge47(p0: NativePtr, p1: NativePtr, p2: Int): Int
@SymbolName("sqlite3_kniBridge48")
private external fun kniBridge48(p0: NativePtr, p1: NativePtr, p2: Long): Long
@SymbolName("sqlite3_kniBridge49")
private external fun kniBridge49(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge50")
private external fun kniBridge50(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge51")
private external fun kniBridge51(p0: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge52")
private external fun kniBridge52(p0: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge53")
private external fun kniBridge53(p0: Int): NativePtr
@SymbolName("sqlite3_kniBridge54")
private external fun kniBridge54(p0: NativePtr, p1: Int, p2: Int): Int
@SymbolName("sqlite3_kniBridge55")
private external fun kniBridge55(p0: NativePtr, p1: NativePtr, p2: Int, p3: NativePtr, p4: NativePtr): Int
@SymbolName("sqlite3_kniBridge56")
private external fun kniBridge56(p0: NativePtr, p1: NativePtr, p2: Int, p3: NativePtr, p4: NativePtr): Int
@SymbolName("sqlite3_kniBridge57")
private external fun kniBridge57(p0: NativePtr, p1: NativePtr, p2: Int, p3: NativePtr, p4: NativePtr): Int
@SymbolName("sqlite3_kniBridge58")
private external fun kniBridge58(p0: NativePtr, p1: NativePtr, p2: Int, p3: NativePtr, p4: NativePtr): Int
@SymbolName("sqlite3_kniBridge59")
private external fun kniBridge59(p0: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge60")
private external fun kniBridge60(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge61")
private external fun kniBridge61(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge62")
private external fun kniBridge62(p0: NativePtr, p1: Int, p2: NativePtr, p3: Int, p4: NativePtr): Int
@SymbolName("sqlite3_kniBridge63")
private external fun kniBridge63(p0: NativePtr, p1: Int, p2: NativePtr, p3: Long, p4: NativePtr): Int
@SymbolName("sqlite3_kniBridge64")
private external fun kniBridge64(p0: NativePtr, p1: Int, p2: Double): Int
@SymbolName("sqlite3_kniBridge65")
private external fun kniBridge65(p0: NativePtr, p1: Int, p2: Int): Int
@SymbolName("sqlite3_kniBridge66")
private external fun kniBridge66(p0: NativePtr, p1: Int, p2: Long): Int
@SymbolName("sqlite3_kniBridge67")
private external fun kniBridge67(p0: NativePtr, p1: Int): Int
@SymbolName("sqlite3_kniBridge68")
private external fun kniBridge68(p0: NativePtr, p1: Int, p2: NativePtr, p3: Int, p4: NativePtr): Int
@SymbolName("sqlite3_kniBridge69")
private external fun kniBridge69(p0: NativePtr, p1: Int, p2: NativePtr, p3: Int, p4: NativePtr): Int
@SymbolName("sqlite3_kniBridge70")
private external fun kniBridge70(p0: NativePtr, p1: Int, p2: NativePtr, p3: Long, p4: NativePtr, p5: Byte): Int
@SymbolName("sqlite3_kniBridge71")
private external fun kniBridge71(p0: NativePtr, p1: Int, p2: NativePtr): Int
@SymbolName("sqlite3_kniBridge72")
private external fun kniBridge72(p0: NativePtr, p1: Int, p2: Int): Int
@SymbolName("sqlite3_kniBridge73")
private external fun kniBridge73(p0: NativePtr, p1: Int, p2: Long): Int
@SymbolName("sqlite3_kniBridge74")
private external fun kniBridge74(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge75")
private external fun kniBridge75(p0: NativePtr, p1: Int): NativePtr
@SymbolName("sqlite3_kniBridge76")
private external fun kniBridge76(p0: NativePtr, p1: NativePtr): Int
@SymbolName("sqlite3_kniBridge77")
private external fun kniBridge77(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge78")
private external fun kniBridge78(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge79")
private external fun kniBridge79(p0: NativePtr, p1: Int): NativePtr
@SymbolName("sqlite3_kniBridge80")
private external fun kniBridge80(p0: NativePtr, p1: Int): NativePtr
@SymbolName("sqlite3_kniBridge81")
private external fun kniBridge81(p0: NativePtr, p1: Int): NativePtr
@SymbolName("sqlite3_kniBridge82")
private external fun kniBridge82(p0: NativePtr, p1: Int): NativePtr
@SymbolName("sqlite3_kniBridge83")
private external fun kniBridge83(p0: NativePtr, p1: Int): NativePtr
@SymbolName("sqlite3_kniBridge84")
private external fun kniBridge84(p0: NativePtr, p1: Int): NativePtr
@SymbolName("sqlite3_kniBridge85")
private external fun kniBridge85(p0: NativePtr, p1: Int): NativePtr
@SymbolName("sqlite3_kniBridge86")
private external fun kniBridge86(p0: NativePtr, p1: Int): NativePtr
@SymbolName("sqlite3_kniBridge87")
private external fun kniBridge87(p0: NativePtr, p1: Int): NativePtr
@SymbolName("sqlite3_kniBridge88")
private external fun kniBridge88(p0: NativePtr, p1: Int): NativePtr
@SymbolName("sqlite3_kniBridge89")
private external fun kniBridge89(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge90")
private external fun kniBridge90(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge91")
private external fun kniBridge91(p0: NativePtr, p1: Int): NativePtr
@SymbolName("sqlite3_kniBridge92")
private external fun kniBridge92(p0: NativePtr, p1: Int): Int
@SymbolName("sqlite3_kniBridge93")
private external fun kniBridge93(p0: NativePtr, p1: Int): Int
@SymbolName("sqlite3_kniBridge94")
private external fun kniBridge94(p0: NativePtr, p1: Int): Double
@SymbolName("sqlite3_kniBridge95")
private external fun kniBridge95(p0: NativePtr, p1: Int): Int
@SymbolName("sqlite3_kniBridge96")
private external fun kniBridge96(p0: NativePtr, p1: Int): Long
@SymbolName("sqlite3_kniBridge97")
private external fun kniBridge97(p0: NativePtr, p1: Int): NativePtr
@SymbolName("sqlite3_kniBridge98")
private external fun kniBridge98(p0: NativePtr, p1: Int): NativePtr
@SymbolName("sqlite3_kniBridge99")
private external fun kniBridge99(p0: NativePtr, p1: Int): Int
@SymbolName("sqlite3_kniBridge100")
private external fun kniBridge100(p0: NativePtr, p1: Int): NativePtr
@SymbolName("sqlite3_kniBridge101")
private external fun kniBridge101(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge102")
private external fun kniBridge102(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge103")
private external fun kniBridge103(p0: NativePtr, p1: NativePtr, p2: Int, p3: Int, p4: NativePtr, p5: NativePtr, p6: NativePtr, p7: NativePtr): Int
@SymbolName("sqlite3_kniBridge104")
private external fun kniBridge104(p0: NativePtr, p1: NativePtr, p2: Int, p3: Int, p4: NativePtr, p5: NativePtr, p6: NativePtr, p7: NativePtr): Int
@SymbolName("sqlite3_kniBridge105")
private external fun kniBridge105(p0: NativePtr, p1: NativePtr, p2: Int, p3: Int, p4: NativePtr, p5: NativePtr, p6: NativePtr, p7: NativePtr, p8: NativePtr): Int
@SymbolName("sqlite3_kniBridge106")
private external fun kniBridge106(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge107")
private external fun kniBridge107(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge108")
private external fun kniBridge108(p0: NativePtr, p1: NativePtr): Int
@SymbolName("sqlite3_kniBridge109")
private external fun kniBridge109(): Int
@SymbolName("sqlite3_kniBridge110")
private external fun kniBridge110(): Unit
@SymbolName("sqlite3_kniBridge111")
private external fun kniBridge111(p0: NativePtr, p1: NativePtr, p2: Long): Int
@SymbolName("sqlite3_kniBridge112")
private external fun kniBridge112(p0: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge113")
private external fun kniBridge113(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge114")
private external fun kniBridge114(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge115")
private external fun kniBridge115(p0: NativePtr): Double
@SymbolName("sqlite3_kniBridge116")
private external fun kniBridge116(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge117")
private external fun kniBridge117(p0: NativePtr): Long
@SymbolName("sqlite3_kniBridge118")
private external fun kniBridge118(p0: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge119")
private external fun kniBridge119(p0: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge120")
private external fun kniBridge120(p0: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge121")
private external fun kniBridge121(p0: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge122")
private external fun kniBridge122(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge123")
private external fun kniBridge123(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge124")
private external fun kniBridge124(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge125")
private external fun kniBridge125(p0: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge126")
private external fun kniBridge126(p0: NativePtr): Unit
@SymbolName("sqlite3_kniBridge127")
private external fun kniBridge127(p0: NativePtr, p1: Int): NativePtr
@SymbolName("sqlite3_kniBridge128")
private external fun kniBridge128(p0: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge129")
private external fun kniBridge129(p0: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge130")
private external fun kniBridge130(p0: NativePtr, p1: Int): NativePtr
@SymbolName("sqlite3_kniBridge131")
private external fun kniBridge131(p0: NativePtr, p1: Int, p2: NativePtr, p3: NativePtr): Unit
@SymbolName("sqlite3_kniBridge132")
private external fun kniBridge132(p0: NativePtr, p1: NativePtr, p2: Int, p3: NativePtr): Unit
@SymbolName("sqlite3_kniBridge133")
private external fun kniBridge133(p0: NativePtr, p1: NativePtr, p2: Long, p3: NativePtr): Unit
@SymbolName("sqlite3_kniBridge134")
private external fun kniBridge134(p0: NativePtr, p1: Double): Unit
@SymbolName("sqlite3_kniBridge135")
private external fun kniBridge135(p0: NativePtr, p1: NativePtr, p2: Int): Unit
@SymbolName("sqlite3_kniBridge136")
private external fun kniBridge136(p0: NativePtr, p1: NativePtr, p2: Int): Unit
@SymbolName("sqlite3_kniBridge137")
private external fun kniBridge137(p0: NativePtr): Unit
@SymbolName("sqlite3_kniBridge138")
private external fun kniBridge138(p0: NativePtr): Unit
@SymbolName("sqlite3_kniBridge139")
private external fun kniBridge139(p0: NativePtr, p1: Int): Unit
@SymbolName("sqlite3_kniBridge140")
private external fun kniBridge140(p0: NativePtr, p1: Int): Unit
@SymbolName("sqlite3_kniBridge141")
private external fun kniBridge141(p0: NativePtr, p1: Long): Unit
@SymbolName("sqlite3_kniBridge142")
private external fun kniBridge142(p0: NativePtr): Unit
@SymbolName("sqlite3_kniBridge143")
private external fun kniBridge143(p0: NativePtr, p1: NativePtr, p2: Int, p3: NativePtr): Unit
@SymbolName("sqlite3_kniBridge144")
private external fun kniBridge144(p0: NativePtr, p1: NativePtr, p2: Long, p3: NativePtr, p4: Byte): Unit
@SymbolName("sqlite3_kniBridge145")
private external fun kniBridge145(p0: NativePtr, p1: NativePtr, p2: Int, p3: NativePtr): Unit
@SymbolName("sqlite3_kniBridge146")
private external fun kniBridge146(p0: NativePtr, p1: NativePtr, p2: Int, p3: NativePtr): Unit
@SymbolName("sqlite3_kniBridge147")
private external fun kniBridge147(p0: NativePtr, p1: NativePtr, p2: Int, p3: NativePtr): Unit
@SymbolName("sqlite3_kniBridge148")
private external fun kniBridge148(p0: NativePtr, p1: NativePtr): Unit
@SymbolName("sqlite3_kniBridge149")
private external fun kniBridge149(p0: NativePtr, p1: Int): Unit
@SymbolName("sqlite3_kniBridge150")
private external fun kniBridge150(p0: NativePtr, p1: Long): Int
@SymbolName("sqlite3_kniBridge151")
private external fun kniBridge151(p0: NativePtr, p1: Int): Unit
@SymbolName("sqlite3_kniBridge152")
private external fun kniBridge152(p0: NativePtr, p1: NativePtr, p2: Int, p3: NativePtr, p4: NativePtr): Int
@SymbolName("sqlite3_kniBridge153")
private external fun kniBridge153(p0: NativePtr, p1: NativePtr, p2: Int, p3: NativePtr, p4: NativePtr, p5: NativePtr): Int
@SymbolName("sqlite3_kniBridge154")
private external fun kniBridge154(p0: NativePtr, p1: NativePtr, p2: Int, p3: NativePtr, p4: NativePtr): Int
@SymbolName("sqlite3_kniBridge155")
private external fun kniBridge155(p0: NativePtr, p1: NativePtr, p2: NativePtr): Int
@SymbolName("sqlite3_kniBridge156")
private external fun kniBridge156(p0: NativePtr, p1: NativePtr, p2: NativePtr): Int
@SymbolName("sqlite3_kniBridge157")
private external fun kniBridge157(p0: Int): Int
@SymbolName("sqlite3_kniBridge158")
private external fun kniBridge158(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge159")
private external fun kniBridge159(p0: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge160")
private external fun kniBridge160(p0: NativePtr, p1: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge161")
private external fun kniBridge161(p0: NativePtr, p1: NativePtr): Int
@SymbolName("sqlite3_kniBridge162")
private external fun kniBridge162(p0: NativePtr, p1: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge163")
private external fun kniBridge163(p0: NativePtr, p1: NativePtr, p2: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge164")
private external fun kniBridge164(p0: NativePtr, p1: NativePtr, p2: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge165")
private external fun kniBridge165(p0: NativePtr, p1: NativePtr, p2: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge166")
private external fun kniBridge166(p0: Int): Int
@SymbolName("sqlite3_kniBridge167")
private external fun kniBridge167(p0: Int): Int
@SymbolName("sqlite3_kniBridge168")
private external fun kniBridge168(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge169")
private external fun kniBridge169(p0: Long): Long
@SymbolName("sqlite3_kniBridge170")
private external fun kniBridge170(p0: Int): Unit
@SymbolName("sqlite3_kniBridge171")
private external fun kniBridge171(p0: NativePtr, p1: NativePtr, p2: NativePtr, p3: NativePtr, p4: NativePtr, p5: NativePtr, p6: NativePtr, p7: NativePtr, p8: NativePtr): Int
@SymbolName("sqlite3_kniBridge172")
private external fun kniBridge172(p0: NativePtr, p1: NativePtr, p2: NativePtr, p3: NativePtr): Int
@SymbolName("sqlite3_kniBridge173")
private external fun kniBridge173(p0: NativePtr, p1: Int): Int
@SymbolName("sqlite3_kniBridge174")
private external fun kniBridge174(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge175")
private external fun kniBridge175(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge176")
private external fun kniBridge176(): Unit
@SymbolName("sqlite3_kniBridge177")
private external fun kniBridge177(p0: NativePtr, p1: NativePtr, p2: NativePtr, p3: NativePtr): Int
@SymbolName("sqlite3_kniBridge178")
private external fun kniBridge178(p0: NativePtr, p1: NativePtr, p2: NativePtr, p3: NativePtr, p4: NativePtr): Int
@SymbolName("sqlite3_kniBridge179")
private external fun kniBridge179(p0: NativePtr, p1: NativePtr): Int
@SymbolName("sqlite3_kniBridge180")
private external fun kniBridge180(p0: NativePtr, p1: NativePtr, p2: Int): Int
@SymbolName("sqlite3_kniBridge181")
private external fun kniBridge181(p0: NativePtr, p1: NativePtr, p2: NativePtr, p3: NativePtr, p4: Long, p5: Int, p6: NativePtr): Int
@SymbolName("sqlite3_kniBridge182")
private external fun kniBridge182(p0: NativePtr, p1: Long): Int
@SymbolName("sqlite3_kniBridge183")
private external fun kniBridge183(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge184")
private external fun kniBridge184(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge185")
private external fun kniBridge185(p0: NativePtr, p1: NativePtr, p2: Int, p3: Int): Int
@SymbolName("sqlite3_kniBridge186")
private external fun kniBridge186(p0: NativePtr, p1: NativePtr, p2: Int, p3: Int): Int
@SymbolName("sqlite3_kniBridge187")
private external fun kniBridge187(p0: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge188")
private external fun kniBridge188(p0: NativePtr, p1: Int): Int
@SymbolName("sqlite3_kniBridge189")
private external fun kniBridge189(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge190")
private external fun kniBridge190(p0: Int): NativePtr
@SymbolName("sqlite3_kniBridge191")
private external fun kniBridge191(p0: NativePtr): Unit
@SymbolName("sqlite3_kniBridge192")
private external fun kniBridge192(p0: NativePtr): Unit
@SymbolName("sqlite3_kniBridge193")
private external fun kniBridge193(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge194")
private external fun kniBridge194(p0: NativePtr): Unit
@SymbolName("sqlite3_kniBridge195")
private external fun kniBridge195(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge196")
private external fun kniBridge196(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge197")
private external fun kniBridge197(p0: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge198")
private external fun kniBridge198(p0: NativePtr, p1: NativePtr, p2: Int, p3: NativePtr): Int
@SymbolName("sqlite3_kniBridge199")
private external fun kniBridge199(): NativePtr
@SymbolName("sqlite3_kniBridge200")
private external fun kniBridge200(p0: Int, p1: NativePtr, p2: NativePtr, p3: Int): Int
@SymbolName("sqlite3_kniBridge201")
private external fun kniBridge201(p0: Int, p1: NativePtr, p2: NativePtr, p3: Int): Int
@SymbolName("sqlite3_kniBridge202")
private external fun kniBridge202(p0: NativePtr, p1: Int, p2: NativePtr, p3: NativePtr, p4: Int): Int
@SymbolName("sqlite3_kniBridge203")
private external fun kniBridge203(p0: NativePtr, p1: Int, p2: Int): Int
@SymbolName("sqlite3_kniBridge204")
private external fun kniBridge204(p0: NativePtr, p1: NativePtr, p2: NativePtr, p3: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge205")
private external fun kniBridge205(p0: NativePtr, p1: Int): Int
@SymbolName("sqlite3_kniBridge206")
private external fun kniBridge206(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge207")
private external fun kniBridge207(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge208")
private external fun kniBridge208(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge209")
private external fun kniBridge209(p0: NativePtr, p1: NativePtr, p2: NativePtr): Int
@SymbolName("sqlite3_kniBridge210")
private external fun kniBridge210(p0: NativePtr, p1: NativePtr): Int
@SymbolName("sqlite3_kniBridge211")
private external fun kniBridge211(p0: NativePtr, p1: NativePtr, p2: Int): Int
@SymbolName("sqlite3_kniBridge212")
private external fun kniBridge212(p0: NativePtr, p1: NativePtr): Int
@SymbolName("sqlite3_kniBridge213")
private external fun kniBridge213(p0: NativePtr, p1: NativePtr, p2: Int): Int
@SymbolName("sqlite3_kniBridge214")
private external fun kniBridge214(): NativePtr
@SymbolName("sqlite3_kniBridge215")
private external fun kniBridge215(p0: NativePtr, p1: NativePtr, p2: NativePtr): NativePtr
@SymbolName("sqlite3_kniBridge216")
private external fun kniBridge216(p0: NativePtr, p1: Int): Int
@SymbolName("sqlite3_kniBridge217")
private external fun kniBridge217(p0: NativePtr, p1: NativePtr): Int
@SymbolName("sqlite3_kniBridge218")
private external fun kniBridge218(p0: NativePtr, p1: NativePtr, p2: Int, p3: NativePtr, p4: NativePtr): Int
@SymbolName("sqlite3_kniBridge219")
private external fun kniBridge219(): NativePtr
@SymbolName("sqlite3_kniBridge220")
private external fun kniBridge220(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge221")
private external fun kniBridge221(p0: NativePtr, p1: Int, p2: Int, p3: NativePtr): Int
@SymbolName("sqlite3_kniBridge222")
private external fun kniBridge222(p0: NativePtr): Unit
@SymbolName("sqlite3_kniBridge223")
private external fun kniBridge223(p0: NativePtr): Int
@SymbolName("sqlite3_kniBridge224")
private external fun kniBridge224(p0: NativePtr, p1: NativePtr, p2: NativePtr): Int
@SymbolName("sqlite3_kniBridge225")
private external fun kniBridge225(p0: NativePtr, p1: NativePtr, p2: NativePtr): Int
@SymbolName("sqlite3_kniBridge226")
private external fun kniBridge226(p0: NativePtr): Unit
@SymbolName("sqlite3_kniBridge227")
private external fun kniBridge227(p0: NativePtr, p1: NativePtr, p2: NativePtr, p3: NativePtr): Int
@SymbolName("sqlite3_kniBridge228")
private external fun kniBridge228(p0: NativePtr, p1: NativePtr, p2: NativePtr, p3: NativePtr, p4: NativePtr): Int
@SymbolName("sqlite3_kniBridge229")
private external fun kniBridge229(): NativePtr
@SymbolName("sqlite3_kniBridge230")
private external fun kniBridge230(): NativePtr
@SymbolName("sqlite3_kniBridge231")
private external fun kniBridge231(): NativePtr
