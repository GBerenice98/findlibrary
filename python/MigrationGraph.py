# -*- coding: utf-8 -*-
import networkx as nx
from matplotlib import pyplot as plt
import csv

#Creation d'un Graphe vide
G = nx.DiGraph()
path="C:\\Users\\clare\\OneDrive\\Documents\\Master2\\Methodologie\\findlibrary\\"
nomGraphe=""
#On cree les arrêtes du Graphe en récupérant les sommets dans le fichier edges.csv, fichier qui contient la liste des pays avec leurs voisins,longitude et latitude
with open(path+'python\\edges.csv') as csvfile:
        csv_reader = csv.reader(csvfile, delimiter=';')
        for rows in csv_reader:
            nomGraphe=rows[9]
            node_prev = G.add_node(rows[0], label=rows[0], weight=rows[2])
            node_next = G.add_node(rows[1], label=rows[1], weight=rows[3])
            G.add_edge(rows[0], rows[1], weight=rows[4], label=rows[4])

        # extract nodes with specific setting of the attribute
        positive_nodes = [n for (n, w) in nx.get_node_attributes(G, 'weight').items() if int(w) > 0]
        negative_nodes = [n for (n, w) in nx.get_node_attributes(G, 'weight').items() if int(w) < 0]
        other_nodes = list(set(G.nodes()) - set(positive_nodes) - set(negative_nodes))

        # recupère les coordonnées de chaque sommet passé en attribut
        #pos = nx.layout.spring_layout(G)
        pos=nx.spring_layout(G)

        #Dessin du graphe
        edges_labels = nx.get_edge_attributes(G, 'label')
        nx.draw_networkx_edges(G, pos)
        nx.draw_networkx_edge_labels(G, pos, edges_labels)
        nx.draw_networkx_labels(G, pos)
        nx.draw_networkx_nodes(G, pos, nodelist=positive_nodes, node_color='green', node_shape='o')
        nx.draw_networkx_nodes(G, pos, nodelist=negative_nodes, node_color='red', node_shape='s')
        nx.draw_networkx_nodes(G, pos, nodelist=other_nodes, node_color='blue', node_shape='v')

        #Sauvegarde du graphe au format PNG
        plt.savefig(path+"src\\main\\java\\miage\\findlibrary\\frontend\\src\\assets\\images\\"+nomGraphe, format="PNG")
        plt.show()