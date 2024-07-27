/**

Node for a general tree
@author Caleb Bessit
@version 16 July 2024

**/

import java.util.ArrayList;

public class TreeNode
{
   
   private int x,y;
   private int biomeIndex;
   private float quality;
   private float value;
   private boolean visited;
   
   private int[] biomeValues = {1,14,28,42,57,71,85,100};
   
   private TreeNode top, bottom, left, right;
   
   public TreeNode(int x, int y, int biomeIndex, float quality){
      this.x = x;
      this.y = y;
      this.top = null;
      this.bottom = null;
      this.left = null;
      this.right = null;
      this.visited = false;

   }
   
   public TreeNode(int x, int y, int biomeIndex, float quality, TreeNode top, TreeNode bottom, TreeNode left, TreeNode right){
      this.x = x;
      this.y = y;
      this.biomeIndex = biomeIndex;
      this.quality = quality;
      this.top = top;
      this.bottom = bottom;
      this.left = left;
      this.right = right;
      this.visited = false;
      
   }
   

  
   public float value(){
      return this.biomeValues[this.biomeIndex]*this.quality;
   }
   
   public void setTop(TreeNode node){
      this.top = node;
   }
      
   public void setBottom(TreeNode node){
      this.bottom = node;
   }
   
   public void setLeft(TreeNode node){
      this.left = node;
   }
   
   public void setRight(TreeNode node){
      this.right = node;
   }
   
   public float getX(){
      return this.x;
      
   }

   public float getY(){
      return this.y;
   }
   
   public void visit(){
      this.visited = true;
   }
   
   public String toString(){
      return String.format("(%d,%d)", this.x, this.y);
   }
   
   
   public TreeNode getTop(){
      return this.top;
   }
      
   public TreeNode getBottom(){
      return this.bottom;
   }
   
   public TreeNode getLeft(){
      return this.left;
   }
   
   public TreeNode getRight(){
      return this.right;
   }
   
   public TreeNode checkSurroundingNodes(){
      float maxvalue = this.bottom.value();
      TreeNode nextNode = this.bottom;

      if (!this.left.visited){
          if ( this.left.value()>maxvalue){
              nextNode = this.left;
              maxvalue = this.left.value();
          }
      }

      if (!this.right.visited){
          if (this.right.value()>maxvalue){
              nextNode = this.right;
              maxvalue = this.right.value();
          }
      }

      // if (!this.bottom.visited){
//           if (this.bottom.value>maxvalue){
//               nextNode = this.bottom;
//               maxvalue = this.bottom.value();
//           }
//       }

      return nextNode;
  }

   
}