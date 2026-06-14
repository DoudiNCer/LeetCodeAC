#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
  pub val: i32,
  pub next: Option<Box<ListNode>>
}

impl ListNode {
  #[inline]
  fn new(val: i32) -> Self {
    ListNode {
      next: None,
      val
    }
  }

  pub fn from_vec(v: Vec<i32>) -> Option<Box<ListNode>> {
    let mut head = None;

    for &val in v.iter().rev() {
      let mut node = Box::new(ListNode::new(val));
      node.next = head;
      head = Some(node);
    }

    head
  }
}