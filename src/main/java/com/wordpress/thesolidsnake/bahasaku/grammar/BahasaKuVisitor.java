// Generated from src/main/resources/BahasaKu.g4 by ANTLR 4.1
package com.wordpress.thesolidsnake.bahasaku.grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BahasaKuParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BahasaKuVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BahasaKuParser#tampilkan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTampilkan(@NotNull BahasaKuParser.TampilkanContext ctx);

	/**
	 * Visit a parse tree produced by {@link BahasaKuParser#BuatObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuatObject(@NotNull BahasaKuParser.BuatObjectContext ctx);

	/**
	 * Visit a parse tree produced by {@link BahasaKuParser#Pembagian}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPembagian(@NotNull BahasaKuParser.PembagianContext ctx);

	/**
	 * Visit a parse tree produced by {@link BahasaKuParser#Perkalian}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPerkalian(@NotNull BahasaKuParser.PerkalianContext ctx);

	/**
	 * Visit a parse tree produced by {@link BahasaKuParser#Pengurangan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPengurangan(@NotNull BahasaKuParser.PenguranganContext ctx);

	/**
	 * Visit a parse tree produced by {@link BahasaKuParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(@NotNull BahasaKuParser.QualifiedNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link BahasaKuParser#BooleanFalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanFalse(@NotNull BahasaKuParser.BooleanFalseContext ctx);

	/**
	 * Visit a parse tree produced by {@link BahasaKuParser#Penjumlahan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPenjumlahan(@NotNull BahasaKuParser.PenjumlahanContext ctx);

	/**
	 * Visit a parse tree produced by {@link BahasaKuParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull BahasaKuParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link BahasaKuParser#Angka}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAngka(@NotNull BahasaKuParser.AngkaContext ctx);

	/**
	 * Visit a parse tree produced by {@link BahasaKuParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull BahasaKuParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BahasaKuParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(@NotNull BahasaKuParser.ArgumentsContext ctx);

	/**
	 * Visit a parse tree produced by {@link BahasaKuParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(@NotNull BahasaKuParser.FileContext ctx);

	/**
	 * Visit a parse tree produced by {@link BahasaKuParser#String}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(@NotNull BahasaKuParser.StringContext ctx);

	/**
	 * Visit a parse tree produced by {@link BahasaKuParser#BooleanTrue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanTrue(@NotNull BahasaKuParser.BooleanTrueContext ctx);

	/**
	 * Visit a parse tree produced by {@link BahasaKuParser#Identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(@NotNull BahasaKuParser.IdentifierContext ctx);

	/**
	 * Visit a parse tree produced by {@link BahasaKuParser#PanggilMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPanggilMethod(@NotNull BahasaKuParser.PanggilMethodContext ctx);

	/**
	 * Visit a parse tree produced by {@link BahasaKuParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(@NotNull BahasaKuParser.ExprListContext ctx);
}