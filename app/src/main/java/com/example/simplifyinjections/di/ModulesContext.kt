package com.example.simplifyinjections.di

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.simplifyinjections.di.factory.ModuleFactory
import com.example.simplifyinjections.di.factory.factoryViewModel

internal object ModulesContext {

    private const val DEFINITION_NOT_FOUND_MESSAGE =
        "Definition not found. Check your class definitions"
    private val dependencyModules: MutableSet<ModuleFactory> = mutableSetOf()

    internal fun addModule(module: ModuleFactory) {
        dependencyModules.add(module)
    }

    internal fun removeModule(module: ModuleFactory) {
        dependencyModules.remove(module)
    }

    internal fun clearAll() {
        dependencyModules.clear()
    }

    /**
     * Inject lazy dependencies
     */
    internal inline fun <reified T : Any> inject(
        mode: LazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED
    ): Lazy<T> {
        return lazy(mode) {
            get()
        }
    }

    /**
     * Inject ViewModels dependencies, using the application lifecycle
     */
    internal inline fun <reified VM : ViewModel> ComponentActivity.viewModel(): Lazy<VM> {
        return viewModels {
            get<VM>().factoryViewModel()
        }
    }

    /**
     * Search dependencies directly
     *
     * Important: It should only be used if the sought dependency is declared in a module added in
     * the context. Otherwise it will throw a [NoClassDefFoundError]
     */
    internal inline fun <reified T : Any> get(): T {
        return dependencyModules.findDependency()
    }

    private inline fun <reified T> MutableSet<ModuleFactory>.findDependency(): T {
        this.forEach { value ->
            (value.getInstance(T::class.java) as? T)?.run {
                return this
            }
        }
        throw NoClassDefFoundError(DEFINITION_NOT_FOUND_MESSAGE)
    }
}
