package io.github.pedrofraca.data.datasource

interface ReadOnlyDataSource<T> {
    fun getAll(): List<T>
}

interface ReadOnlyDataSourceWithFilter<T, S> : ReadOnlyDataSource<T>{
    fun get(param : S): T
}

interface WriteDataSource<T> : ReadOnlyDataSource<T> {
    fun save(item: T) : Boolean
}

interface WriteDataSourceWithFilter<T, S> : ReadOnlyDataSourceWithFilter<T, S> {
    fun save(item: T, param : S) : Boolean
}