package com.core.fullstack.SearchEngine;

import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.NIOFSDirectory;

public class LuceneSearchEngine {

    public static void main(String[] args) {
        try {
            // Indexing
            Directory index = NIOFSDirectory.open(Paths.get("index"));
            StandardAnalyzer analyzer = new StandardAnalyzer();
            IndexWriterConfig config = new IndexWriterConfig(analyzer);
            IndexWriter writer = new IndexWriter(index, config);
            FieldType TYPE = new FieldType();
            Document doc1 = new Document();
            doc1.add(new TextField("content", "Lucene is a full-text search engine library in Java. Anjali is using",Field.Store.YES));
            writer.addDocument(doc1);

            Document doc2 = new Document();
            doc2.add(new TextField("content", "Anjali knows Apache Lucene is highly scalable, providing efficient indexing and searching.", Field.Store.YES));
            writer.addDocument(doc2);

            writer.close();

            // Searching
            // String queryString = "search engine";
            String queryString = "Anjali";
            Query query = new QueryParser("content", analyzer).parse(queryString);

            int hitsPerPage = 10;
            DirectoryReader reader = DirectoryReader.open(index);
            IndexSearcher searcher = new IndexSearcher(reader);
            TopDocs docs = searcher.search(query, hitsPerPage);
            ScoreDoc[] hits = docs.scoreDocs;

            // Displaying search results
            System.out.println("Found " + hits.length + " hits for query: " + queryString);
            for (int i = 0; i < hits.length; ++i) {
                int docId = hits[i].doc;
                Document d = searcher.doc(docId);
                System.out.println((i + 1) + ". " + d.get("content"));
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}