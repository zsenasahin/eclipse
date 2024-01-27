package veriYapilari;

public class AVLTree {
	public static Node root;

	private int height(Node node) {
		if (node == null)
			return 0;
		return node.height;
	}

	private int max(int a, int b) {
		return (a > b) ? a : b;
	}

	private int getBalance(Node node) {
		if (node == null)
			return 0;
		return height(node.leftChild) - height(node.rightChild);
	}

	private Node rightRotate(Node y) {
		Node x = y.leftChild;
		Node T2 = x.rightChild;

		x.rightChild = y;
		y.leftChild = T2;

		y.height = max(height(y.leftChild), height(y.rightChild)) + 1;
		x.height = max(height(x.leftChild), height(x.rightChild)) + 1;

		return x; // döndürme işlemi sonrasında yeni kök
	}

	private Node leftRotate(Node x) {
		Node y = x.rightChild;
		Node T2 = y.leftChild;

		y.leftChild = x;
		x.rightChild = T2;

		x.height = max(height(x.leftChild), height(x.rightChild)) + 1;
		y.height = max(height(y.leftChild), height(y.rightChild)) + 1;

		return y;
	}

	private Node insert(Node node, int ogrenciNo, String isim, String soyisim, int yas) {
		if (node == null)
			return new Node(ogrenciNo, isim, soyisim, yas);

		if (ogrenciNo < node.ogrenciNo)
			node.leftChild = insert(node.leftChild, ogrenciNo, isim, soyisim, yas);
		else if (ogrenciNo > node.ogrenciNo)
			node.rightChild = insert(node.rightChild, ogrenciNo, isim, soyisim, yas);
		else
			return node;

		node.height = 1 + max(height(node.leftChild), height(node.rightChild));

		int balance = getBalance(node);

		if (balance > 1 && ogrenciNo < node.leftChild.ogrenciNo) // sol ağaç daha yüksekse ve sola ekleme yapılmışsa
			return rightRotate(node);

		if (balance < -1 && ogrenciNo > node.rightChild.ogrenciNo) // sağ ağaç daha yüksekse ve sağa ekleme yapılmışsa
			return leftRotate(node);

		if (balance > 1 && ogrenciNo > node.leftChild.ogrenciNo) { // sol ağaç daha yüksekse ve sağa ekleme yapılmışsa
			node.leftChild = leftRotate(node.leftChild);
			return rightRotate(node);
		}

		if (balance < -1 && ogrenciNo < node.rightChild.ogrenciNo) { // sağ açac daha yüksekse ve sola ekleme yapılmışsa
			node.rightChild = rightRotate(node.rightChild);
			return leftRotate(node);
		}

		return node;
	}

	public void insert(int ogrenciNo, String isim, String soyisim, int yas) {
		root = insert(root, ogrenciNo, isim, soyisim, yas);
	}

	// ---------INORDER SIRALAMA---------

	public void inorder(Node node) {
		if (node != null) {
			inorder(node.leftChild);
			System.out.println(node);
			inorder(node.rightChild);
		}
	}

	// --------PREORDER SIRALAMA----------

	public void preorder(Node node) {
		if (node != null) {
			System.out.println(node);
			preorder(node.leftChild);
			preorder(node.rightChild);
		}
	}

	// --------POSTORDER SIRALAMA--------

	public void postorder(Node node) {
		if (node != null) {
			postorder(node.leftChild);
			postorder(node.rightChild);
			System.out.println(node);
		}
	}

	// ---------------------------------------

	public Node kokBul(Node root) {
		return root;
	}

	// ---------------------------------------

	public Node yaprakBul(Node node) {
		if (root == null) {
			System.out.println("Ağaç boş.");
			return null;
		}
		if (node != null) {
			if (node.leftChild == null && node.rightChild == null) {
				System.out.println("Bulunan Yaprak Düğüm: " + node.ogrenciNo);
				return node;
			}

			Node leftLeaf = yaprakBul(node.leftChild);
			if (leftLeaf != null) {
				return leftLeaf;
			}

			Node rightLeaf = yaprakBul(node.rightChild);
			if (rightLeaf != null) {
				return rightLeaf;
			}
		}

		return null;
	}

	// ---------------------------------------

	public Node sagCocukBul(Node root) { // sol yok sağ var.
		if (root == null) {
			return null;
		}
		if (root.leftChild == null && root.rightChild != null) {
			return root;
		}
		Node leftResult = sagCocukBul(root.leftChild);
		Node rightResult = sagCocukBul(root.rightChild);

		return leftResult != null ? leftResult : rightResult;
	}

	// ---------------------------------------

	public Node solCocukBul(Node root) { // sol var sağ yok
		if (root == null) {
			return null;
		}

		if (root.leftChild != null && root.rightChild == null) {
			return root;
		}

		Node leftResult = solCocukBul(root.leftChild);
		if (leftResult != null) {
			return leftResult;
		}

		Node rightResult = solCocukBul(root.rightChild);
		if (rightResult != null) {
			return rightResult;
		}
		return null;
	}

	// -----------------------------------------
	public Node birSagVeBirSol(Node root) {
		if (root == null) {
			return null;
		}
		Node randomNode = findRandomNodeWithBothChildren(root);
		return randomNode;
	}

	private Node findRandomNodeWithBothChildren(Node node) {
		if (node == null) {
			return null;
		}

		if (node.leftChild != null && node.rightChild != null) {
			return node;
		}

		Node leftResult = findRandomNodeWithBothChildren(node.leftChild);
		if (leftResult != null) {
			return leftResult;
		}

		return findRandomNodeWithBothChildren(node.rightChild);
	}

	// ************************************

	private Node findNode(Node root, int ogrenciNo) {
		if (root == null || root.ogrenciNo == ogrenciNo)
			return root;

		if (ogrenciNo < root.ogrenciNo)
			return findNode(root.leftChild, ogrenciNo);

		return findNode(root.rightChild, ogrenciNo);
	}

	public int getSubtreeSize(int ogrenciNo) {
		Node node = findNode(root, ogrenciNo);

		if (node == null) {
			System.out.println("Düğüm bulunamadı.");
			return 0;
		}

		return getSubtreeSize(node);
	}

	private int getSubtreeSize(Node node) {
		if (node == null)
			return 0;

		return 1 + getSubtreeSize(node.leftChild) + getSubtreeSize(node.rightChild);
	}

	// *******************************************************************************
	public void findMinMax(int ogrenciNo) {
		Node node = findNode(root, ogrenciNo);

		if (node == null) {
			System.out.println("Düğüm bulunamadı.");
			return;
		}

		Node minNode = findMinNode(node);
		Node maxNode = findMaxNode(node);

		System.out.println("Subtree'deki En Küçük Düğüm: " + minNode);
		System.out.println("Subtree'deki En Büyük Düğüm: " + maxNode);
	}

	//Belirli bir düğümden itibaren en küçük düğümü bulma
	private Node findMinNode(Node node) {
		while (node.leftChild != null) {
			node = node.leftChild;
		}
		return node;
	}

	//Belirli bir düğümden itibaren en büyük düğümü bulma
	private Node findMaxNode(Node node) {
		while (node.rightChild != null) {
			node = node.rightChild;
		}
		return node;
	}

	// *****************************************

	public void printLeaves(Node node) {
		if (node != null) {
			if (node.rightChild == null && node.leftChild == null) {
				System.out.println(node);
			}
			printLeaves(node.leftChild);
			printLeaves(node.rightChild);
		}
	}

	// -----------------------------------

	// Silme işlemi için
	private Node minValueNode(Node node) {
		Node current = node;

		while (current.leftChild != null) {
			current = current.leftChild;
		}

		return current;
	}

	public void delete(int ogrenciNo, String isim, String soyisim, int yas) {
		root = deleteRecursive(root, ogrenciNo, isim, soyisim, yas);
	}

	private Node deleteRecursive(Node root, int ogrenciNo, String isim, String soyisim, int yas) {
		if (root == null) {
			return null;
		}

		// Öğrenci numarasını karşılaştır
		if (ogrenciNo < root.ogrenciNo) {
			root.leftChild = deleteRecursive(root.leftChild, ogrenciNo, isim, soyisim, yas);
		} else if (ogrenciNo > root.ogrenciNo) {
			root.rightChild = deleteRecursive(root.rightChild, ogrenciNo, isim, soyisim, yas);
		} else { // eşitse

			// 1. Hiç çocuğu yoksa veya sadece bir çocuğu varsa
			if (root.leftChild == null || root.rightChild == null) {
				Node temp = (root.leftChild != null) ? root.leftChild : root.rightChild;

				// Hiç çocuğu yoksa
				if (temp == null) {
					temp = root;
					root = null;
				} else {
					// Sadece bir çocuğu varsa
					root = temp;
				}
			} else {
				Node temp = minValueNode(root.rightChild);
				root.ogrenciNo = temp.ogrenciNo;
				root.isim = temp.isim;
				root.soyisim = temp.soyisim;
				root.yas = temp.yas;
				root.rightChild = deleteRecursive(root.rightChild, temp.ogrenciNo, temp.isim, temp.soyisim, temp.yas);
			}
		}

		// Eğer ağaçta sadece bir düğüm varsa (yapı boşalıyorsa) null döndür
		if (root == null) {
			return null;
		}

		// Düğüm yüksekliğini güncelle
		root.height = 1 + max(height(root.leftChild), height(root.rightChild));

		// Denge kontrolü ve gerekirse rotasyon
		int balance = getBalance(root);

		// Solun fazla oldugu durumlar
		if (balance > 1) {
			// Sol-sol durumu
			if (getBalance(root.leftChild) >= 0) {
				return rightRotate(root);
			}
			// Sol-sağ durumu
			else {
				root.leftChild = leftRotate(root.leftChild);
				return rightRotate(root);
			}
		}

		// Sağın fazla oldugu durumlar
		if (balance < -1) {
			// Sağ-sağ durumu
			if (getBalance(root.rightChild) <= 0) {
				return leftRotate(root);
			}
			// Sağ-sol durumu
			else {
				root.rightChild = rightRotate(root.rightChild);
				return leftRotate(root);
			}
		}

		return root;
	}

}