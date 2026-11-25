# shopapp · Numbered Planner

The graphify pipeline has run. Everything below is a concrete, numbered deliverable.
Come back and tell me a number — I'll make it. Say "all" to do them in order.

## 1. Re-run semantic extraction on the two lost chunks
Chunks 02 (`ECサイト_機能設計書.pdf`) and 04 (クラス図・シーケンス図) were corrupted
(double-escaped JSON / truncated) and replaced with placeholders. Their semantic
extraction is gone. Re-dispatch subagents on those two files, merge, and rebuild the graph.
This is the single biggest gap in the current output.

## 2. Improve community labels
Current labels are auto-generated from node names (e.g. "Adminmenuservlet",
"Resultset .insert()"). Replace with hand-picked plain-language names that a
non-technical reader would understand.

## 3. Add SVG export
`graphify-out/graph.svg` — embeds in Notion / GitHub.

## 4. Add GraphML export
`graphify-out/graph.graphml` — opens in Gephi / yEd.

## 5. Add Neo4j cypher export
`graphify-out/cypher.txt` — ready to import into Neo4j.

## 6. Add FalkorDB cypher export
`graphify-out/cypher.txt` — ready to import into FalkorDB.

## 7. Build Obsidian vault
`graphify-out/obsidian/` — one Markdown note per node, linked into a vault.

## 8. Build agent-crawlable wiki
`graphify-out/wiki/` — `index.md` plus one article per community.

## 9. Run a graph query
You ask a question, I traverse the graph and give you the answer.
Example: "What calls OrderDAO?", "Trace the data flow through ProductDAO."

## 10. Explain a node
Plain-language explanation of any node in the graph.

## 11. Find shortest path between two concepts
`graphify path <A> <B>`.

## 12. Rebuild with --force
After fixing the semantic extraction (#1), do a full clean rebuild allowing the graph
to shrink/grow as the new extraction dictates.

## 13. Add --watch mode
Watch the folder and auto-rebuild on code changes (no LLM needed).

## 14. Run a benchmark
Generate a synthetic corpus, time the pipeline end-to-end, report the numbers.

## 15. Start MCP stdio server
Expose the graph over MCP so other agents can query it.

## 16. Export as directed graph
Rebuild with `--directed` so edge direction (source → target) is preserved.

## 17. Add video/audio transcription
If any `.mp4`/`.mp3` files exist, transcribe them and fold the transcripts in.

## 18. Add a node to the graph
`graphify add <url>` — fetch a URL, save to `./raw`, update the graph.

## 19. Re-run clustering only
`--cluster-only` — rerun community detection on the existing graph.json without
re-extracting anything.

## 20. Generate a health re-check report
Re-run `diagnose_extraction` and write a fresh, honest health summary to
`graphify-out/HEALTH.md`, including the known gaps.

## 21. Add a .graphifyignore
Add files/patterns to skip on the next detect run.

## 22. Update the graph incrementally
`--update` — re-extract only new/changed files, merge into the existing graph.

## 23. Write a README for graphify-out
One page explaining what each output file is, how to read graph.json, and how to
query the graph. Useful for handing off to someone else.

## 24. Deep-mode re-extraction
Re-run semantic extraction with `--mode deep` for richer INFERRED edges.

---

**Current state:** 233 nodes · 495 edges · 12 communities.
Outputs live in `graphify-out/` (graph.json, GRAPH_REPORT.md, graph.html, manifest.json).